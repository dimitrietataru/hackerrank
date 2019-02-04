/**
 *              RUNNING TIME AND COMPLEXITY | C#
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 25
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
            int n = reader.NextInt;
            Console.WriteLine(Solve(n));
        }

        reader.Close();
    }

    static string Solve(int n)
    {
        if (n <= 1)
        {
            return "Not prime";
        }

        if (n == 2 || n == 3)
        {
            return "Prime";
        }

        if (n % 2 == 0 || n % 3 == 0)
        {
            return "Not prime";
        }

        for (int i = 4; (i * i) <= n; ++i)
        {
            if (n % i == 0)
            {
                return "Not prime";
            }
        }

        return "Prime";
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

    public void Close() => input.Close();
}
