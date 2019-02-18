using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(true);
        int k = reader.NextArrInt[1];
        int[] array = reader.NextArrInt;
        reader.Close();

        Solve(array, k);
    }

    static void Solve(int[] array, int k)
    {
        var set = new SortedSet<int>(array);
        int result = set.Where(i => set.Contains(i + k)).Count();

        Console.WriteLine(result);
    }

    static void SolveBinarySearch(int[] array, int k)
    {
        int result = 0;
        Array.Sort(array);

        for (int i = 0; i < array.Length; ++i)
        {
            if (Array.BinarySearch(array, i, array.Length - i, k + array[i]) > 0)
            {
                result++;
            }
        }

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
