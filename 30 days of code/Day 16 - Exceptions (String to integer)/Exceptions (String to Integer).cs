/**
 *              EXCEPTIONS (STRING TO INTEGER) | C#
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 16
 */

using System;
using System.IO;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(false);
        string input = reader.NextString;
        reader.Close();

        try
        {
            int n = int.Parse(input);
            Console.WriteLine(n);
        }
        catch (FormatException)
        {
            Console.WriteLine("Bad String");
        }
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
