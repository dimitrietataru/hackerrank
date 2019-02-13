using System;
using System.IO;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(true);

        int n = reader.NextInt;
        int[][] matrix = reader.NextMatrix(n);

        Solve(matrix, n);

        reader.Close();
    }

    static void Solve(int[][] matrix, int n)
    {
        int sumDiagonal1 = 0;
        int sumDiagonal2 = 0;

        for (int i = 0; i < n; ++i)
        {
            sumDiagonal1 += matrix[i][i];
            sumDiagonal2 += matrix[i][n - i - 1];
        }

        var result = Math.Abs(sumDiagonal1 - sumDiagonal2);
        Console.WriteLine(result);
    }
}

class InputReader
{
    private TextReader input;

    public InputReader(bool fromFile)
    {
        input = fromFile ? new StreamReader("input.txt") : Console.In;
    }

    public int NextInt => int.Parse(input.ReadLine());

    public int[] NextArrInt => Array.ConvertAll(input.ReadLine().Split(), int.Parse);

    public int[][] NextMatrix(int n)
    {
        int[][] matrix = new int[n][];
        for (int i = 0; i < n; ++i)
        {
            matrix[i] = NextArrInt;
        }
        return matrix;
    }

    public void Close() => input.Close();
}
