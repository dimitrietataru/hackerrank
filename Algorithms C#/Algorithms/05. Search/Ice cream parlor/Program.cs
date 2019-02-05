using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(true);

        int testCases = reader.NextInt;
        while (testCases-- > 0)
        {
            int money = reader.NextInt;
            int n = reader.NextInt;
            int[] costs = reader.NextArrInt;

            Solve(costs, money);
        }

        reader.Close();
    }

    static void Solve(int[] costs, int money)
    {
        var priceIndexes = new Dictionary<int, List<int>>();
        for (int i = 0; i < costs.Length; ++i)
        {
            var price = costs[i];
            if (priceIndexes.ContainsKey(price))
            {
                priceIndexes[price].Add(i);
            }
            else
            {
                priceIndexes.Add(price, new List<int> { i });
            }
        }

        var first = new List<int>();
        var second = new List<int>();
        for (int i = 1; i <= money / 2; ++i)
        {
            if (priceIndexes.ContainsKey(i) && priceIndexes.ContainsKey(money - i))
            {
                if (i * 2 == money)
                {
                    var ordered = priceIndexes[i].OrderBy(index => index).ToList();
                    first.Add(ordered[0]);
                    second.Add(ordered[1]);
                }
                else
                {
                    first.Add(priceIndexes[i].Min());
                    second.Add(priceIndexes[money - i].Min());
                }
            }
        }

        Print(first, second);
    }

    static void Print(List<int> firstIndexes, List<int> secondIndexes)
    {
        var best = firstIndexes
            .Zip(secondIndexes, (i1, i2) => new { I1 = i1, I2 = i2 })
            .OrderBy(pair => pair.I1)
            .First();

        Console.WriteLine($"{Math.Min(best.I1, best.I2) + 1} {Math.Max(best.I1, best.I2) + 1}");
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
