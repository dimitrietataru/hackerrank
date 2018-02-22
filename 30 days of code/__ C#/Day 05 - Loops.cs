/**
 *              LOOPS | C#
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 05
 */

using System;
using System.IO;

class Program
{
    //static TextReader read = Console.In;
    static StreamReader read = new StreamReader("input.txt");

    static void Main(string[] args)
    {
        int n = int.Parse(read.ReadLine());
        read.Close();

        for (int i = 1; i <= 10; ++i)
        {
            Console.WriteLine($"{n} x {i} = {n * i}");
        }
    }
}