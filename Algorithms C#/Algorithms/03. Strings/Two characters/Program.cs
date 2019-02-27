using System;
using System.IO;
using System.Linq;
using System.Text.RegularExpressions;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(true);
        int n = reader.NextInt;
        string input = reader.NextString;
        reader.Close();

        Solve(input);
    }

    static void Solve(string input)
    {
        if (input.Length < 2)
        {
            Console.WriteLine("0");
            return;
        }

        int result = int.MinValue;
        var chars = input.ToHashSet();

        foreach (char c1 in chars)
        {
            foreach (char c2 in chars)
            {
                var current = ReplaceAndValidate(input, c1, c2);
                result = Math.Max(current, result);
            }
        }
        
        Console.WriteLine(result);
    }

    static int ReplaceAndValidate(string s, char c1, char c2)
    {
        string temp = Regex.Replace(s, $"[^{c1}{c2}]", "");

        for (int i = 0; i < temp.Length - 1; ++i)
        {
            if (temp[i] == temp[i + 1])
            {
                return 0;
            }
        }

        return temp.Length;
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
