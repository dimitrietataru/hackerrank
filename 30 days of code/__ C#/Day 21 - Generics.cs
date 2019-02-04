/**
 *              GENERICS | C#
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 21
 */

using System;
using System.IO;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(false);
        int n = reader.NextInt;
        int[] integers = reader.NextArrInt;
        string[] strings = reader.NextArrString;
        reader.Close();

        PrintArray(integers);
        PrintArray(strings);
    }

    static void PrintArray<T>(T[] array)
    {
        foreach (T item in array)
        {
            Console.WriteLine(item);
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

    public string[] NextArrString => NextLine.Split();

    public void Close() => input.Close();
}
