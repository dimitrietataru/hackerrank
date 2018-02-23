/**
 *              RECURSION | C#
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 09
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

        int result = Factorial(n);
        Console.WriteLine(result);
    }

    private static int Factorial(int n)
    {
        if (n == 0)
        {
            return 1;
        }
        return n * Factorial(n - 1);
    }
}