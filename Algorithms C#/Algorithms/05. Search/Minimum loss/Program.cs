using System;
using System.IO;
using System.Linq;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(true);
        int n = reader.NextInt;
        long[] prices = reader.NextArrLong;
        reader.Close();

        Solve(prices, n);
    }

    static void Solve(long[] prices, int n)
    {
        var result = long.MaxValue;

        _ = prices
            .Select((p, i) => new { Price = p, Index = i })
            .OrderBy(pair => pair.Price)
            .Aggregate((first, second) =>
            {
                if (first.Index > second.Index
                    && second.Price - first.Price < result)
                {
                    result = second.Price - first.Price;
                    return first;
                }
                return second;
            });

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
