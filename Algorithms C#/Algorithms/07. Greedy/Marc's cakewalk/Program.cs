using System;
using System.IO;
using System.Linq;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(true);
        int n = reader.NextInt;
        int[] array = reader.NextArrInt;
        reader.Close();

        Solve(array, n);
    }

    static void Solve(int[] array, int n)
    {
        long power = 0;
        long result = array
            .OrderByDescending(i => i)
            .Select(i => (long)i)
            .Aggregate(0L, (i1, i2) => i1 + i2 * (long)Math.Pow(2, power++));

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

    public int[] NextArrInt => Array.ConvertAll(input.ReadLine().Split(), int.Parse);
    
    public void Close() => input.Close();
}
