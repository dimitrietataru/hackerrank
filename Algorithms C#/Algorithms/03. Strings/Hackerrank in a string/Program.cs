using System;
using System.IO;
using System.Text.RegularExpressions;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(true);

        int n = reader.NextInt;
        while (n-- > 0)
        {
            string input = reader.NextString;

            Solve(input);
        }

        reader.Close();
    }

    static void Solve(string input)
    {
        var search = "hackerrank";
        var i = 0;

        foreach (var ch in input)
        {
            if (ch == search[i] && (++i == search.Length))
            {
                Console.WriteLine("YES");
                return;
            }
        }

        Console.WriteLine("NO");
    }

    static void Solve2(string input)
    {
        var isMatch = Regex.IsMatch(input, ".*h.*a.*c.*k.*e.*r.*r.*a.*n.*k.*");

        Console.WriteLine(isMatch ? "YES" : "NO");
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
