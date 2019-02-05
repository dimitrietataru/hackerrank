using System;
using System.IO;
using System.Linq;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(true);

        int size = reader.NextInt;
        Solve(size);

        reader.Close();
    }

    static void Solve(int size)
    {
        int[][] result = new int[4][];
        for (int i = 1; i <= result.Length; ++i)
        {
            for (int j = 1; j <= result.Length; ++j)
            {
                var visited = new bool[size, size];
                var jumps = Jump(visited, i, j, 0, 0, size - 1);
                Console.Write($"{Math.Max(jumps, -1)} ");
            }
            Console.WriteLine();
        }
    }

    static int Jump(bool[,] visited, int jumpX, int jumpY, int x, int y, int size)
    {
        //Console.WriteLine($"Visiting {x} x {y}");

        if (!IsValidCoordinate(x, y, size))
        {
            return 0;
        }

        if (visited[x, y])
        {
            return -999_999;
        }

        if (x == size && y == size)
        {
            return 1;
        }

        visited[x, y] = true;

        var arrayX = GetXDirections(jumpX);
        var arrayY = GetXDirections(jumpY);

        return 1 +
            new[]
            {
                Jump(visited, jumpX, jumpY, x + arrayX[0], y + arrayY[0], size),
                Jump(visited, jumpX, jumpY, x + arrayX[1], y + arrayY[1], size),
                Jump(visited, jumpX, jumpY, x + arrayX[2], y + arrayY[2], size),
                Jump(visited, jumpX, jumpY, x + arrayX[3], y + arrayY[3], size),
                Jump(visited, jumpX, jumpY, x + arrayX[4], y + arrayY[4], size),
                Jump(visited, jumpX, jumpY, x + arrayX[5], y + arrayY[5], size),
                Jump(visited, jumpX, jumpY, x + arrayX[6], y + arrayY[6], size),
                Jump(visited, jumpX, jumpY, x + arrayX[7], y + arrayY[7], size)
            }
//            .Where(val => val >= 0)
            .Max();
    }

    static bool IsValidCoordinate(int x, int y, int size)
    {
        return !(x < 0 || x >= size || y < 0 || y >= size);
    }

    static int[] GetXDirections(int jump)
    {
        return new[] { -jump, -jump, -jump, 0, 0, jump, jump, jump };
    }

    static int[] GetYDirections(int jump)
    {
        return new[] { -jump, 0, jump, -jump, jump, -jump, 0, jump };
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
