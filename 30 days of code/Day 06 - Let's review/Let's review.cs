/**
 *              LET'S REVIEW | C#
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 06
 */

using System;
using System.IO;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(false);
        int testCases = reader.NextInt;

        while (testCases-- > 0)
        {
            string input = reader.NextString;
            Solve(input);
        }

        reader.Close();
    }

    static void Solve(string input)
    {
        string even = string.Empty;
        string odd = string.Empty;

        for (int i = 0; i < input.Length; ++i)
        {
            if (i % 2 == 0)
            {
                even += input[i];
            }
            else
            {
                odd += input[i];
            }
        }

        Console.WriteLine($"{even} {odd}");
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

    public string NextString => NextLine;

    public void Close() => input.Close();
}
