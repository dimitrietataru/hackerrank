/**
 *              GENERICS | C#
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 21
 */

using System;
using System.IO;

class Program
{
    //static TextReader read = Console.In;
    static StreamReader read = new StreamReader("input.txt");

    public static void PrintArray<T>(T[] array)
    {
        foreach (T t in array)
        {
            Console.WriteLine(t);
        }
    }

    static void Main(string[] args)
    {
        int n = int.Parse(read.ReadLine());
        string[] line = read.ReadLine().Split(' ');
        int[] intArray = Array.ConvertAll(line, int.Parse);

        n = int.Parse(read.ReadLine());
        string[] stringArray = read.ReadLine().Split(' ');

        read.Close();

        PrintArray<Int32>(intArray);
        PrintArray<String>(stringArray);
    }
}