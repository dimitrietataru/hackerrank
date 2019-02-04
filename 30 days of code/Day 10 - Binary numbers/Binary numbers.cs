/**
 *              BINARY NUMBERS | C#
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 10
 */

using System;
using System.Collections.Generic;
using System.IO;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(false);
        int n = reader.NextInt;
        reader.Close();

        BinaryNumbers(n);
    }
    
    private static void BinaryNumbers(int n)
    {
        var bytes = IntToBinary(n);
        int currentCount = 0;
        int result = 0;

        bytes.ForEach(b =>
        {
            currentCount = (b == 1) ? (currentCount + 1) : 0;
            result = Math.Max(currentCount, result);
        });

        Console.WriteLine(result);
    }

    private static List<int> IntToBinary(int n)
    {
        var bytes = new List<int>();

        while (n > 0)
        {
            bytes.Add(n % 2);
            n /= 2;
        }

        return bytes;
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
