using System;
using System.IO;
using System.Linq;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(true);

        int n = reader.NextInt;
        string input = reader.NextString;
        int r = reader.NextInt;

        reader.Close();

        Solve(input, r);
    }

    static void Solve(string input, int r)
    {
        var result = input
            .ToCharArray()
            .Select(c =>
            {
                if (c >= 65 && c <= 90)
                {
                    return (char)((c - 'A' + r) % 26 + 'A');
                }

                if (c >= 97 && c <= 122)
                {
                    return (char)((c - 'a' + r) % 26 + 'a');
                }

                return c;
            });

        Console.WriteLine(string.Join("", result));
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
