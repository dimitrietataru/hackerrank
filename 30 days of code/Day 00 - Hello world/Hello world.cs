/**
 *              HELLO, WORLD | C#
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 00
*/

using System;
using System.IO;

class Program
{
    //static TextReader read = Console.In;
    static StreamReader read = new StreamReader("input.txt");

    static void Main(string[] args)
    {
        string s = read.ReadLine();
        read.Close();

        Console.WriteLine("Hello, World.");
        Console.WriteLine(s);
    }
}