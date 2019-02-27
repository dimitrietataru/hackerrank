using System;
using System.Collections.Generic;
using System.IO;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(true);

        long[] line = reader.NextArrLong;
        long[] coins = reader.NextArrLong;

        Array.Sort(coins, (i1, i2) => i2.CompareTo(i1));

        reader.Close();

        var result = Solve(coins, line[0], 0, new Dictionary<string, long>());
        Console.WriteLine(result);
    }

    static long Solve(long[] coins, long money, int index, Dictionary<string, long> map)
    {
        if (money == 0)
        {
            return 1;
        }

        if (index >= coins.Length)
        {
            return 0;
        }
        
        string key = $"{money}-{index}";
        if (map.ContainsKey(key))
        {
            return map[key];
        }

        long sum = 0;
        long ways = 0;
        while (sum <= money)
        {
            long remaining = money - sum;
            ways += Solve(coins, remaining, index + 1, map);
            sum += coins[index];
        }

        map.Add(key, ways);

        return ways;
    }
}

class InputReader
{
    private TextReader input;

    public InputReader(bool fromFile)
    {
        input = fromFile ? new StreamReader("input.txt") : Console.In;
    }

    public long[] NextArrLong => Array.ConvertAll(input.ReadLine().Split(), long.Parse);

    public void Close() => input.Close();
}
