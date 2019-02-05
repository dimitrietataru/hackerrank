using System;
using System.Collections.Generic;
using System.Globalization;
using System.IO;
using System.Linq;

class Program
{
    static void Main(string[] args)
    {
        GetAllIndexes();
        Console.WriteLine();
        Console.WriteLine();

        var reader = new InputReader(true);

        int testCases = reader.NextInt;
        while (testCases-- > 0)
        {
            int money = reader.NextInt;
            int n = reader.NextInt;
            int[] prices = reader.NextArrInt;

            Solve(prices, money);
        }

        reader.Close();
    }

    static List<int> GetAllIndexes(int[] array, int value)
    {
        var result = new List<int>();

        var index = Array.BinarySearch(array, 2);
        if (index >= 0)
        {
            result.Add(index);
        }
        else
        {
            return result;
        }
        
        var index2 = Array.BinarySearch(array, 0, index, 2);
        result.Add(index2);
        var index3 = Array.BinarySearch(array, index2 + 1, (array.Length - index2 - 1), 2);
        result.Add(index2);

        result.ForEach(x => Console.WriteLine(x));

        return result.Where(x => x >= 0).OrderBy(x => x).ToList();
    }

    static void Solve(int[] prices, int money)
    {
        var orderedPrices = prices.OrderBy(_ => _).ToArray();
        var pricesAsList = prices.ToList();

        var priceIndexes = prices
            .Select((p, i) => new Price(p, i))
            .OrderBy(price => price.Value)
            .ThenBy(price => price.Index)
            .ToArray();

        for (int i = 0; i < prices.Length; ++i)
        {
            int searchIndex = Array.BinarySearch(orderedPrices, money - prices[i]);
            

            Console.WriteLine($"I = {i}");
            Console.WriteLine($"Looked for {money - prices[i]}. Found it at position {searchIndex}");

            if (searchIndex >= 0)
            {
                int nextIndex = Array.BinarySearch(orderedPrices, searchIndex + 1, orderedPrices.Length - (searchIndex + 1), money - prices[i]);
                //Console.WriteLine("@@@ " + nextIndex);

                //if (nextIndex >= 0)
                //{

                //}
                var index1 = pricesAsList.IndexOf(prices[i]);
                var index2 = pricesAsList.IndexOf(money - prices[i]);
                if (index1 == index2)
                {
                }
                Console.WriteLine($"### {index1 + 1} {index2 + 1}");
            }
        }

        //var possiblePrices = new List<(Price, Price)>();
        //for (int i = 1; i < money / 2; ++i)
        //{
        //    if (Array.BinarySearch(prices, i) != -1
        //        && Array.BinarySearch(prices, money - i) != -1)
        //    {
        //        var price1 = priceIndexes.FirstOrDefault(p => p.Value == i);
        //        var price2 = priceIndexes.FirstOrDefault(p => p.Value == money - i);

        //        if (price1 != null && price2 != null)
        //            possiblePrices.Add((price1, price2));
        //    }
        //}

        //var result = possiblePrices.OrderBy(price => price.Item1.Index).FirstOrDefault();
        //Console.WriteLine($"{result.Item1.Index + 1} {result.Item2.Index + 1}");
    }
}

class Price
{
    public int Value { get; set; }
    public int Index { get; set; }

    public Price(int value, int index)
    {
        Value = value;
        Index = index;
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
    public List<int> NextInts => NextArrInt.ToList();

    public long NextLong => long.Parse(input.ReadLine());
    public long[] NextArrLong => Array.ConvertAll(input.ReadLine().Split(), long.Parse);
    public List<long> NextLongs => NextArrLong.ToList();

    public double NextDouble => double.Parse(input.ReadLine(), CultureInfo.InvariantCulture);
    public double[] NextArrDouble => Array.ConvertAll(input.ReadLine().Split(), d => double.Parse(d, CultureInfo.InvariantCulture));
    public List<double> NextDoubles => NextArrDouble.ToList();

    public char NextChar => Convert.ToChar(input.ReadLine());
    public char[] NextArrChar => input.ReadLine().Replace(" ", "").ToCharArray();
    public List<char> NextChars => NextArrChar.ToList();

    public string NextString => input.ReadLine();
    public string[] NextArrString => input.ReadLine().Split();
    public List<string> NextStrings => NextArrString.ToList();

    public int[][] NextMatrix(int n)
    {
        int[][] matrix = new int[n][];
        for (int i = 0; i < n; ++i)
        {
            matrix[i] = NextArrInt;
        }
        return matrix;
    }

    public void Close() => input.Close();
}
