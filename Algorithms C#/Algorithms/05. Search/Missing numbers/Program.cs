using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

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
        var diff = a.Except(b).OrderBy(x => x).ToHashSet();

        var result = new SortedSet<int>();

        //int indexA = 0;
        //for (int i = 0; i < b.Length; ++i)
        //{
        //    if (indexA >= a.Length)
        //    {
        //        result.Add(b[i]);
        //    }
        //    else if (b[i] == a[indexA])
        //    {
        //        indexA++;
        //    }
        //    else 
        //    {
        //        result.Add(b[i]);
        //    }
        //}

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
