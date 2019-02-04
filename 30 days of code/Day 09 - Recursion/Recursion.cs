/**
 *              RECURSION | C#
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 09
 */

using System;
using System.IO;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(false);
        int n = reader.NextInt;
        reader.Close();

        int result = Solve(n);
        Console.WriteLine(result);
    }

    static int Solve(int n)
    {
        if (n == 0)
        {
            return 1;
        }

        return n * Solve(n - 1);
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
