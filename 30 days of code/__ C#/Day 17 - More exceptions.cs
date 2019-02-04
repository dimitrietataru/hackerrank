/**
 *              MORE EXCEPTIONS | C#
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 17
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
            int[] array = reader.NextArrInt;

            try
            {
                int answer = new Calculator().Power(array[0], array[1]);
                Console.WriteLine(answer);
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
            }
        }

        reader.Close();
    }
}

class Calculator
{
    public int Power(int n, int p)
    {
        if (n < 0 || p < 0)
        {
            throw new Exception("n and p should be non-negative");
        }

        return (int)Math.Pow(n, p);
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
