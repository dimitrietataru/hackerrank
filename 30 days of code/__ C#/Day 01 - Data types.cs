/**
 *              DATA TYPES | C#
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 01
 */

using System;
using System.IO;

class Program
{
    //static TextReader read = Console.In;
    static StreamReader read = new StreamReader("input.txt");

    static void Main(string[] args)
    {
        int i = 4;
        double d = 4.0;
        string s = "HackerRank ";

        int i2 = Int32.Parse(read.ReadLine());
        double d2 = Double.Parse(read.ReadLine().Replace(".", ","));
        string s2 = read.ReadLine();
        read.Close();

        Console.WriteLine(i + i2);
        Console.WriteLine("{0:.0}", d + d2);
        Console.WriteLine(s + s2);
    }
}