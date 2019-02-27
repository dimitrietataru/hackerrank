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
            int n = reader.NextInt;
            var rows = new List<char[]>();
            for (int i = 0; i < n; ++i)
            {
                var row = reader.NextString.ToCharArray();
                rows.Add(row.OrderBy(c => c).ToArray());
            }

            char[,] matrix = new char[n, rows[0].Length];
            for (int i = 0; i < matrix.GetLength(0); ++i)
            {
                for (int j = 0; j < matrix.GetLength(1); ++j)
                {
                    matrix[i, j] = rows[i][j];
                }
            }

            Solve(matrix, n);
        }

        reader.Close();
    }

    static void Solve(char[,] matrix, int n)
    {
        for (int i = 1; i < matrix.GetLength(0); ++i)
        {
            for (int j = 0; j < matrix.GetLength(1); ++j)
            {
                if (matrix[i, j] < matrix[i - 1, j])
                {
                    Console.WriteLine("NO");
                    return;
                }
            }
        }

        Console.WriteLine("YES");
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

    public string NextString => input.ReadLine();

    public void Close() => input.Close();
}
