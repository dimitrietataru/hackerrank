/**
 *              DICTIONARIES AND MAPS | C#
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 08
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
        var phoneBook = new Dictionary<string, int>(n);

        for (int i = 0; i < n; ++i)
        {
            var line = reader.NextArrString;
            phoneBook.Add(line[0], int.Parse(line[1]));
        }

        string s;
        while ((s = reader.NextString) != null)
        {
            if (phoneBook.ContainsKey(s))
            {
                Console.WriteLine($"{s}={phoneBook[s]}");
            }
            else
            {
                Console.WriteLine("Not found");
            }
        }

        reader.Close();
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

    public string NextString => NextLine;

    public string[] NextArrString => NextLine.Split();

    public void Close() => input.Close();
}
