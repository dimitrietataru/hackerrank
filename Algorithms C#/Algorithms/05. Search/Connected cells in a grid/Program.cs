using System;
using System.IO;

class Program
{
    static readonly int[] dX = new[] { -1, -1, -1, 0, 0, 1, 1, 1 };
    static readonly int[] dY = new[] { -1, 0, 1, -1, 1, -1, 0, 1 };

    static void Main(string[] args)
    {
        var reader = new InputReader(true);
        int n = reader.NextInt;
        int m = reader.NextInt;
        var matrix = reader.NextMatrix(n, m);
        reader.Close();

        Solve(matrix, n, m);
    }

    static void Solve(int[,] matrix, int n, int m)
    {
        var result = 0;

        for (int i = 0; i < n; ++i)
        {
            for (int j = 0; j < m; ++j)
            {
                if (matrix[i, j] == 1)
                {
                    result = Math.Max(result, Visit(matrix, i, j));
                }
            }
        }

        Console.WriteLine(result);
    }

    static int Visit(int[,] matrix, int x, int y)
    {
        matrix[x, y] = 0;
        int result = 1;

        for (int i = 0; i < dX.Length; ++i)
        {
            int nextX = x + dX[i];
            int nextY = y + dY[i];

            if ((nextX >=0 && nextX < matrix.GetLength(0))
                && (nextY >= 0 && nextY < matrix.GetLength(1))
                && matrix[nextX, nextY] == 1)
            {
                result += Visit(matrix, x + dX[i], y + dY[i]);
            }
        }

        return result;
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

    public int[,] NextMatrix(int n, int m)
    {
        int[,] matrix = new int[n, m];

        for (int i = 0; i < n; ++i)
        {
            int[] line = NextArrInt;
            for (int j = 0; j < m; ++j)
            {
                matrix[i, j] = line[j];
            }
        }

        return matrix;
    }

    public void Close() => input.Close();
}
