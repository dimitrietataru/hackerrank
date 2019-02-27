using System;
using System.IO;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(true);
        string input = reader.NextString;
        reader.Close();

        Solve(input);
    }

    static void Solve(string input)
    {
        int result = 0;
        for (int i = 0; i < input.Length; i += 3)
        {
            result += input[i] == 'S' ? 0 : 1;
            result += input[i + 1] == 'O' ? 0 : 1;
            result += input[i + 2] == 'S' ? 0 : 1;
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

    public string NextString => input.ReadLine();

    public void Close() => input.Close();
}
