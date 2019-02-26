using System;
using System.IO;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(true);

        int testCases = reader.NextInt;
        while (testCases-- > 0)
        {
            string input = reader.NextString;

            Solve(input);
        }

        reader.Close();
    }

    static void Solve(string s)
    {
        for (int i = 0; i <= s.Length / 2; ++i)
        {
            var diff1 = Math.Abs(s[i] - s[i + 1]);
            var diff2 = Math.Abs(s[s.Length - i - 1] - s[s.Length - i - 2]);

            if (diff1 != diff2)
            {
                Console.WriteLine("Not Funny");
                return;
            }
        }

        Console.WriteLine("Funny");
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
