/**
 *              2D ARRAYS | C#
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 11
 */

using System;
using System.IO;

class Program
{
    //static TextReader read = Console.In;
    static StreamReader read = new StreamReader("input.txt");

    static void Main(string[] args)
    {
        int n = 6;
        int[][] matrix = new int[6][];
        for (int i = 0; i < n; ++i)
        {
            string[] line = read.ReadLine().Split(' ');
            matrix[i] = Array.ConvertAll(line, int.Parse);
        }
        read.Close();

        HourGlass(matrix, n);
    }

    private static void HourGlass(int[][] matrix, int n)
    {
        int max = int.MinValue;
        for (int i = 1; i < n - 1; ++i)
        {
            for (int j = 1; j < n - 1; ++j)
            {
                int currentSum =
                    matrix[i - 1][j - 1] + matrix[i - 1][j] + matrix[i - 1][j + 1]
                                           + matrix[i][j] +
                    matrix[i + 1][j - 1] + matrix[i + 1][j] + matrix[i + 1][j + 1];
                max = (currentSum > max) ? currentSum : max;
            }
        }

        Console.WriteLine(max);
    }
}