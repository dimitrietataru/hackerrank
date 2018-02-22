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
    //static TextReader read = Console.In;
    static StreamReader read = new StreamReader("input.txt");

    static void Main(string[] args)
    {
        int n = int.Parse(read.ReadLine());
        Dictionary<string, int> phoneBook = new Dictionary<string, int>(n);
        for (int i = 0; i < n; ++i)
        {
            string[] line = read.ReadLine().Split(' ');
            phoneBook.Add(line[0], int.Parse(line[1]));
        }

        string s = null;
        while ((s = read.ReadLine()) != null)
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

        read.Close();
    }
}