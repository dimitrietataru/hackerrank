/**
 *              INTRO TO CONDITIONAL STATEMENTS | C#
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 03
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

        IntroToConditionalStatements(n);
    }

    private static void IntroToConditionalStatements(int n)
    {
        if (n % 2 == 1)
        {
            Console.WriteLine("Weird");
        }
        else
        {
            if ((n > 20) || ((n >= 2) && (n <= 5)))
            {
                Console.WriteLine("Not Weird");
            }
            if ((n >= 6) && (n <= 20))
            {
                Console.WriteLine("Weird");
            }
        }
    }
}