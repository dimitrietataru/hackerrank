using System;
using System.Collections.Generic;
using System.IO;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(true);
        int n = reader.NextInt;
        int[] after = reader.NextArrInt;
        int m = reader.NextInt;
        int[] before = reader.NextArrInt;
        reader.Close();

        Solve(after, before);
    }

    static void Solve(int[] a, int[] b)
    {
        var freq = new int[100_001];
        var diff = new SortedSet<int>();

        foreach (int i in a)
        {
            freq[i]++;
        }
        
        foreach (int i in b)
        {
            if (freq[i]-- == 0)
            {
                diff.Add(i);
            }
        }

        Console.WriteLine(string.Join(" ", diff));
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
