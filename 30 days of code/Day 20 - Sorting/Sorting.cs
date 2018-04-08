/**
 *              SORTING | C#
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 20
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

        Sort(array);
    }

    private static void Sort(int[] array)
    {
        int totalSwaps = 0;
        bool isSorted;

        do
        {
            isSorted = true;
            for (int i = 0; i < array.Length - 1; ++i)
            {
                if (array[i] > array[i + 1])
                {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;

                    isSorted = false;
                    totalSwaps++;
                }
            }
        } while (!isSorted);

        Console.WriteLine("Array is sorted in " + totalSwaps + " swaps.");
        Console.WriteLine("First Element: " + array[0]);
        Console.WriteLine("Last Element: " + array[array.Length - 1]);
    }
}