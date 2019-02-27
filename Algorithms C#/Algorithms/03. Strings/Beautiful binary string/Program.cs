using System;
using System.IO;

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
        int result = 0;

        for (int i = 1; i < input.Length - 1; ++i)
        {
            if (input[i] == '1' && input[i - 1] == '0' && input[i + 1] == '0')
            {
                input = $"{input.Substring(0, i)}1{input.Substring(i + 2)}";
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
