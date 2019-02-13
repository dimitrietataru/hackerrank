using System;
using System.IO;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(true);
        string input = reader.NextString;
        reader.Close();

        Console.WriteLine(DateTime.ParseExact(input, "hh:mm:sstt", null).ToString("HH:mm:ss"));
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
