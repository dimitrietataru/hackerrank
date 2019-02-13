using System;
using System.IO;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(true);
        int n = reader.NextInt;
        var unsortedItems = new string[n];

        for (int i = 0; i < n; ++i)
        {
            unsortedItems[i] = reader.NextString;
        }

        reader.Close();

        Solve(unsortedItems);
    }

    static void Solve(string[] items)
    {
        Array.Sort(items, (s1, s2) => (s1.Length == s2.Length)
            ? string.Compare(s1, s2, StringComparison.Ordinal)
            : s1.Length - s2.Length
        );

        Console.WriteLine(string.Join("\n", items));
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

    public string NextString => input.ReadLine();

    public void Close() => input.Close();
}
