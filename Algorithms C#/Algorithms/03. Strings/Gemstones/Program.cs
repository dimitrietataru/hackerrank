using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(true);

        var gems = new List<char[]>();
        int n = reader.NextInt;
        
        while (n-- > 0)
        {
            gems.Add(reader.NextString.ToCharArray());
        }

        reader.Close();

        Solve(gems);
    }

    static void Solve(List<char[]> gems)
    {
        var result = gems.Aggregate((g1, g2) => g1.Intersect(g2).ToArray());

        Console.WriteLine(result.Length);
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
