/**
 *              INTRO TO CONDITIONAL STATEMENTS | C#
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 03
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

        Solve(n);
    }

    static void Solve(int n)
    {
        if (n % 2 == 1)
        {
            Console.WriteLine("Weird");
        }
        else
        {
            if (n > 20 || (n >= 2 && n <= 5))
            {
                Console.WriteLine("Not Weird");
            }
            if (n >= 6 && n <= 20)
            {
                Console.WriteLine("Weird");
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
    
    public void Close() => input.Close();
}
