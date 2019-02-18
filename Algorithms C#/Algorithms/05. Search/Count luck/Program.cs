using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(true);

        int testCases = reader.NextInt;
        while (testCases-- > 0)
        {
            int[] line = reader.NextArrInt;
            char[,] matrix = new char[line[0], line[1]];

            var start = new KeyValuePair<int, int>(0, 0);
            for (int i = 0; i < line[0]; ++i)
            {
                var row = reader.NextString;
                for (int j = 0; j < row.Length; ++j)
                {
                    matrix[i, j] = row[j];
                    if ('M'.Equals(row[j]))
                    {
                        start = new KeyValuePair<int, int>(i, j);
                    }
                }
            }

            int k = reader.NextInt;

            Solve(matrix, line[0], line[1], k, start);
        }

        reader.Close();
    }

    static void PrintMatrix<T>(T[,] matrix)
    {
        for (int i = 0; i < matrix.GetLength(0); ++i)
        {
            for (int j = 0; j < matrix.GetLength(1); ++j)
            {
                Console.Write($"{matrix[i, j]} ");
            }
            Console.WriteLine();
        }
        Console.WriteLine();
    }

    static void Solve(char[,] matrix, int n, int m, int k, KeyValuePair<int, int> start)
    {
        ////PrintMatrix(matrix);

        var visited = new bool[n, m];
        var queue = new Queue<KeyValuePair<int, int>>();
        queue.Enqueue(start);

        int result = 0;
        while (queue.Any())
        {
            var cell = queue.Dequeue();
            int x = cell.Key;
            int y = cell.Value;

            visited[x, y] = true;

            if (matrix[x, y] == '*')
            {
                break;
            }

            int adjacent = 0;

            if ((x >= 0 && x < n) && (y + 1 >= 0 && y + 1 < m) && (matrix[x, y + 1] == '.' || matrix[x, y + 1] == '*') && !visited[x, y + 1])
            {
                queue.Enqueue(new KeyValuePair<int, int>(x, y + 1));
                adjacent++;
            }

            if ((x >= 0 && x < n) && (y - 1 >= 0 && y - 1 < m) && (matrix[x, y - 1] == '.' || matrix[x, y - 1] == '*') && !visited[x, y - 1])
            {
                queue.Enqueue(new KeyValuePair<int, int>(x, y - 1));
                adjacent++;
            }

            if ((x - 1 >= 0 && x - 1 < n) && (y >= 0 && y < m) && (matrix[x - 1, y] == '.' || matrix[x - 1, y] == '*') && !visited[x - 1, y])
            {
                queue.Enqueue(new KeyValuePair<int, int>(x - 1, y));
                adjacent++;
            }

            if ((x + 1>= 0 && x + 1 < n) && (y >= 0 && y < m) && (matrix[x + 1, y] == '.' || matrix[x + 1, y] == '*') && !visited[x + 1, y])
            {
                queue.Enqueue(new KeyValuePair<int, int>(x + 1, y));
                adjacent++;
            }

            if (adjacent > 1)
            {
                result++;
            }
        }

        Console.WriteLine((result == k) ? "Impressed" : "Oops!");
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

    public string NextString => input.ReadLine();

    public void Close() => input.Close();
}
