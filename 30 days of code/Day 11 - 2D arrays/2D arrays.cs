/**
 *              2D ARRAYS | C#
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 11
 */

using System;
using System.IO;

class Program
{
    static void Main()
    {
        var reader = new InputReader(false);
        var matrix = new int[6][];

        for (int i = 0; i < 6; ++i)
        {
            matrix[i] = reader.NextArrInt;
        }

        reader.Close();

        Solve(matrix, 6);
    }

    static void Solve(int[][] matrix, int n)
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
                max = Math.Max(currentSum, max);
            }
        }

        Console.WriteLine(max);
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

    public int[] NextArrInt => Array.ConvertAll(NextLine.Split(), int.Parse);

    public void Close() => input.Close();
}
