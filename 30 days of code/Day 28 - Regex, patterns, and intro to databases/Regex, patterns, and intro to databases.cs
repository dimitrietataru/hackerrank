/**
 *              REGEX, PATTERNS, AND INTRO TO DATABASES | C#
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 28
 */

using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text.RegularExpressions;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(true);
        int testCases = reader.NextInt;

        var names = new List<string>();
        while (testCases-- > 0)
        {
            var row = reader.NextArrString;
            if (IsValidEmail(row[1]))
            {
                names.Add(row[0]);
            }
        }
        reader.Close();

        names.OrderBy(name => name).ToList().ForEach(name => Console.WriteLine(name));
    }

    static bool IsValidEmail(string email) => Regex.IsMatch(email, @"(.+)@gmail.com");
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

    public string[] NextArrString => NextLine.Split();

    public void Close() => input.Close();
}
