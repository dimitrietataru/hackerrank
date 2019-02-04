/**
 *              DATA TYPES | C#
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 01
 */

using System;
using System.Globalization;
using System.IO;

class Program
{
    static void Main(string[] args)
    {
        int i = 4;
        double d = 4.0;
        string s = "HackerRank ";

        var reader = new InputReader(false);
        int i2 = reader.NextInt;
        double d2 = reader.NextDouble;
        string s2 = reader.NextString;
        reader.Close();

        Console.WriteLine(i + i2);
        Console.WriteLine("{0:.0}", d + d2);
        Console.WriteLine(s + s2);
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

    public int NextInt => int.Parse(NextLine);

    public double NextDouble => double.Parse(NextLine, CultureInfo.InvariantCulture);

    public string NextString => NextLine;

    public void Close() => input.Close();
}
