using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(true);

        int[] firstLine = reader.NextArrInt;
        int n = firstLine[0];
        int k = firstLine[1];

        var contests = new List<KeyValuePair<int, int>>();
        while (n-- > 0)
        {
            var line = reader.NextArrInt;
            contests.Add(new KeyValuePair<int, int>(line[0], line[1]));
        }

        reader.Close();

        Solve(contests, k);
    }

    static void Solve(List<KeyValuePair<int, int>> contests, int k)
    {
        var importants = contests.Where(c => c.Value == 1).OrderByDescending(c => c.Key).ToList();
        var unimportants = contests.Where(c => c.Value == 0).ToList();

        int result = 0;
        result += importants.Take(k).Aggregate(0, (c1, c2) => c1 + c2.Key);
        result += importants.Skip(k).Aggregate(0, (c1, c2) => c1 - c2.Key);
        result += unimportants.Aggregate(0, (c1, c2) => c1 + c2.Key);

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

    public int[] NextArrInt => Array.ConvertAll(input.ReadLine().Split(), int.Parse);

    public void Close() => input.Close();
}
