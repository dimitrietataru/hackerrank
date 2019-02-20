using System;
using System.IO;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(true);
        int n = reader.NextInt;
        long[] array = reader.NextArrLong;
        reader.Close();

        Solve(array, n);
    }

    static void Solve(long[] array, int n)
    {
        Array.Sort(array);

        long result = int.MaxValue;
        for (int i = 0; i < array.Length - 1; ++i)
        {
            long diff = Math.Abs(array[i] - array[i + 1]);
            result = Math.Min(diff, result);
        }

        Console.WriteLine(result);
    }
}

class InputReader
{
    private TextReader input;

    public InputReader(bool fromFile)
    {
        input = fromFile ? new StreamReader("input.txt") : Console.In;
    }

    public int NextInt => int.Parse(input.ReadLine());

    public long[] NextArrLong => Array.ConvertAll(input.ReadLine().Split(), long.Parse);

    public void Close() => input.Close();
}
