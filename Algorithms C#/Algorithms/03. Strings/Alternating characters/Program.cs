using System;
using System.IO;

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
        int result = 0;
        for (int i = 0; i < input.Length - 1; ++i)
        {
            if (input[i] == input[i + 1])
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

    public int NextInt => int.Parse(input.ReadLine());

    public string NextString => input.ReadLine();

    public void Close() => input.Close();
}
