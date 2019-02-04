/**
 *              SCOPE | C#
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 14
 */

using System;
using System.IO;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(false);

        int n = reader.NextInt;
        int[] elements = reader.NextArrInt;

        reader.Close();

        var difference = new Difference(elements);
        difference.ComputeDifference();

        Console.WriteLine(difference.maximumDifference);
    }
}

class Difference
{
    public int maximumDifference;
    private readonly int[] elements;

    public Difference(int[] elements) => this.elements = elements;

    public void ComputeDifference()
    {
        maximumDifference = int.MinValue;
        for (int i = 0; i < elements.Length - 1; ++i)
        {
            for (int j = i + 1; j < elements.Length; ++j)
            {
                int difference = Math.Abs(elements[i] - elements[j]);
                maximumDifference = Math.Max(difference, maximumDifference);
            }
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

    public int NextInt => int.Parse(NextLine);

    public int[] NextArrInt => Array.ConvertAll(NextLine.Split(), int.Parse);

    public void Close() => input.Close();
}
