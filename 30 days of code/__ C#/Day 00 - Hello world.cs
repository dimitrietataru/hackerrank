/**
 *              HELLO, WORLD | C#
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 00
*/

using System;
using System.IO;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(true);
        string text = reader.NextString;
        reader.Close();

        Console.WriteLine("Hello, World.");
        Console.WriteLine(text);
    }
}

class InputReader
{
    private TextReader input;

    public InputReader(bool fromFile)
    {
        input = fromFile ? new StreamReader("input.txt") : Console.In;
    }

    public string NextLine => input.ReadLine();

    public string NextString => NextLine;

    public void Close() => input.Close();
}
