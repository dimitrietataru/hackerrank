using System;
using System.IO;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(true);

        string input = reader.NextString;
        Solve(input);

        reader.Close();
    }

    static void Solve(string input)
    {
        int result = 1;
        string toLower = input.ToLower();
        
        for (int i = 0; i < input.Length; ++i)
        {
            if (input[i] != toLower[i])
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

    public string NextString => input.ReadLine();

    public void Close() => input.Close();
}
