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
            var result = Solve(input);

            Console.WriteLine(result);
        }

        reader.Close();
    }

    static string Solve(string input)
    {
        if (input.Length == 1)
        {
            return "NO";
        }

        for (int i = 1; i <= input.Length / 2; ++i)
        {
            string s = input.Substring(0, i);
            long value = long.Parse(s);

            string result = value.ToString();
            while (result.Length < input.Length)
            {
                value++;
                result += value.ToString();
            }

            if (input == result)
            {
                return $"YES {input.Substring(0, i)}";
            }
        }

        return "NO";
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
