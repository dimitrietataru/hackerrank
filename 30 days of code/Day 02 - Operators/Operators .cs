/**
 *              OPERATORS | C#
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 02
 */

using System;
using System.Globalization;
using System.IO;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(false);
        double mealCost = reader.NextDouble;
        int tipPercent = reader.NextInt;
        int taxPercent = reader.NextInt;
        reader.Close();

        double tip = (mealCost * tipPercent) / 100;
        double tax = (mealCost * taxPercent) / 100;
        int totalCost = (int)Math.Round(mealCost + tip + tax);

        Console.WriteLine(totalCost);
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

    public void Close() => input.Close();
}
