using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(true);
        int n = reader.NextInt;
        reader.Close();

        for (int i = 1; i < n; ++i)
        {
            for (int j = 1; j < n; ++j)
            {
                Console.Write($"{SolveBFS(i, j, n)} ");
            }
            Console.WriteLine();
        }
    }

    static int SolveBFS(int dirA, int dirB, int n)
    {
        var dX = new[] { 1, 1, -1, -1 };
        var dY = new[] { 1, -1, 1, -1 };
        var possibleDirections = dX
            .Select((_, i1) => new KeyValuePair<int, int>(dirA * dX[i1], dirB * dY[i1]))
            .Concat(dX.Select((_, i2) => new KeyValuePair<int, int>(dirB * dX[i2], dirA * dY[i2])))
            .Distinct()
            .ToList();

        int[,] visits = new int[n, n];
        visits[0, 0] = 1;

        var queue = new Queue<KeyValuePair<int, int>>();
        queue.Enqueue(new KeyValuePair<int, int>(0, 0));
        while (queue.Count > 0)
        {
            var cell = queue.Dequeue();
            int x = cell.Key;
            int y = cell.Value;

            possibleDirections.ForEach(direction =>
            {
                int a = direction.Key;
                int b = direction.Value;

                if ((x + a < n && x + a >= 0) && (y + b >= 0 && y + b < n) && visits[x + a, y + b] == 0)
                {
                    visits[x + a, y + b] = visits[x, y] + 1;
                    queue.Enqueue(new KeyValuePair<int, int>(x + a, y + b));
                }
            });
        }

        return visits[n - 1, n - 1] - 1;
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

    public void Close() => input.Close();
}
