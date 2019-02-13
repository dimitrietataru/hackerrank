using System;
using System.IO;
using System.Linq;
using System.Numerics;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(true);
        string[] array = reader.NextArrString;
        reader.Close();

        Solve(array);
    }

    static void Solve(string[] array)
    {
        var bigArray = array.Select(x => BigInteger.Parse(x)).ToList();
        var sum = bigArray.Aggregate((b1, b2) => b1 + b2);
        var min = bigArray.Min();
        var max = bigArray.Max();

        Console.WriteLine($"{sum - max} {sum - min}");
    }
}

class InputReader
{
    private TextReader input;

    public InputReader(bool fromFile)
    {
        input = fromFile ? new StreamReader("input.txt") : Console.In;
    }

    public string[] NextArrString => input.ReadLine().Split();

    public void Close() => input.Close();
}
