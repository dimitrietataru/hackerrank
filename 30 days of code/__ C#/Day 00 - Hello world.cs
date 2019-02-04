/**
 *              HELLO, WORLD | C#
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 00
*/

using System;
using System.IO;

public class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader();

        string text = reader.NextString;

        Console.WriteLine("Hello, World.");
        Console.WriteLine(text);
    }
}

public class InputReader
{
    private TextReader @in;

    public InputReader(bool fromFile = false)
    {
        @in = fromFile
            ? new StreamReader("input.txt")
            : Console.In;
    }

    public string NextString => @in.ReadLine();
}
