/**
 *              ARRAYS | C#
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 07
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
        string[] line = read.ReadLine().Split(' ');
        int[] array = Array.ConvertAll(line, int.Parse);
        read.Close();

        for (int i = n - 1; i >= 0; --i)
        {
            Console.Write("{0} ", array[i]);
        }
    }
}