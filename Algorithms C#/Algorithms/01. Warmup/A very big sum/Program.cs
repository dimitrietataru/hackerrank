using System;
using System.IO;
using System.Numerics;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(true);

        int n = reader.NextInt;
        long[] numbers = reader.NextArrLong;

        Solve(numbers);

        reader.Close();
    }

    static void Solve(long[] numbers)
    {
        var sum = new BigInteger();
        
        for (int i = 0; i < numbers.Length; ++i)
        {
            sum += numbers[i];
        }

        Console.WriteLine(sum);
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
