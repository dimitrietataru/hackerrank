using System;
using System.IO;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(true);

        int n = reader.NextInt;
        int[] a = reader.NextArrInt;
        int[] b = reader.NextArrInt;

        reader.Close();

        Solve(a, b);
    }

    static void Solve(int[] a, int[] b)
    {
        int[] freq = new int[1001];
        for (int i = 0; i < a.Length; ++i)
        {
            freq[a[i]]++;
        }

        int result = 0;
        for (int i = 0; i < b.Length; ++i)
        {
            if (freq[b[i]] > 0)
            {
                result++;
                freq[b[i]]--;
            }
        }

        result += (result < a.Length) ? 1 : -1;

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
