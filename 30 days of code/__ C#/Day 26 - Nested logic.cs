/**
 *              NESTED LOGIC | C#
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 26
 */

using System;
using System.IO;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(true);
        int[] retDate = reader.NextArrInt;
        int[] lastDate = reader.NextArrInt;
        reader.Close();

        var result = Solve(retDate[0], retDate[1], retDate[2], lastDate[0], lastDate[1], lastDate[2]);
        Console.WriteLine(result);
    }

    static int Solve(int retDay, int retMonth, int retYear, int lastDay, int lastMonth, int lastYear)
    {
        if (retYear > lastYear)
        {
            return 10000;
        }

        if (retYear == lastYear)
        {
            if (retMonth > lastMonth)
            {
                return 500 * (retMonth - lastMonth);
            }
            else if (retMonth == lastMonth && retDay > lastDay)
            {
                return 15 * (retDay - lastDay);
            }
        }

        return 0;
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

    public int[] NextArrInt => Array.ConvertAll(NextLine.Split(), int.Parse);

    public void Close() => input.Close();
}
