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

    static void Solve(string input)
    {
        int result = 0;

        for (int i = 0; i < input.Length / 2; ++i)
        {
            if (input[i] != input[input.Length - i - 1])
            {
                result += Math.Abs(input[i] - input[input.Length - i - 1]);
            }
        }

        Console.WriteLine(result);
    }

    static int SolveR(string input, int i, int j)
    {
        if (i >= j)
        {
            return 0;
        }

        return Math.Abs(input[i] - input[j]) + SolveR(input, ++i, --j);
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
