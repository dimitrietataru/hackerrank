/**
 *              BITWISE AND | C#
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 29
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
            int[] line = reader.NextArrInt;
            Solve(line[0], line[1]);
        }

        reader.Close();
    }

    static void Solve(int n, int k)
    {
        int max = 0;

        for (int i = 1; i <= n - 1; ++i)
        {
            for (int j = i + 1; j <= n; ++j)
            {
                int and = i & j;
                max = (and > max && and < k) ? and : max;
            }
        }

        Console.WriteLine(max);
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
