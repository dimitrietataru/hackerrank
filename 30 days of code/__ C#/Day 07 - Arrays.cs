/**
 *              ARRAYS | C#
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 07
 */

using System;
using System.IO;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(false);
        int n = reader.NextInt;
        int[] array = reader.NextArrInt;
        reader.Close();

        for (int i = n - 1; i >= 0; --i)
        {
            Console.Write("{0} ", array[i]);
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
