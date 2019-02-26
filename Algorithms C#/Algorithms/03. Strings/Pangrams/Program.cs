using System;
using System.Collections.Generic;
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
        var letters = new SortedSet<char>(input.Trim().Replace(" ", "").ToLower());

        Console.WriteLine(letters.Count == 26 ? "pangram" : "not pangram");
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
