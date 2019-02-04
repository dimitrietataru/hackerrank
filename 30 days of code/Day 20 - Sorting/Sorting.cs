/**
 *              SORTING | C#
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 20
 */

using System;
using System.IO;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(false);
        int n = reader.NextInt;
        int[] array = reader.NextArrInt;
        reader.Close();

        Sort(array);
    }

    static void Sort(int[] array)
    {
        int swaps = 0;
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
                    swaps++;
                }
            }
        } while (!isSorted);

        Console.WriteLine("Array is sorted in " + swaps + " swaps.");
        Console.WriteLine("First Element: " + array[0]);
        Console.WriteLine("Last Element: " + array[array.Length - 1]);
    }
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

    public int[] NextArrInt => Array.ConvertAll(NextLine.Split(), int.Parse);

    public void Close() => input.Close();
}
