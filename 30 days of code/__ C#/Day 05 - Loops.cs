/**
 *              LOOPS | C#
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 05
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

        for (int i = 1; i <= 10; ++i)
        {
            Console.WriteLine($"{n} x {i} = {n * i}");
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

    public void Close() => input.Close();
}
