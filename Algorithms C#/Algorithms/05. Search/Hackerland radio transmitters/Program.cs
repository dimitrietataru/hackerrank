using System;
using System.IO;
using System.Linq;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(true);

        int[] line = reader.NextArrInt;
        int n = line[0];
        int cover = line[1];
        int[] locations = reader.NextArrInt;

        reader.Close();

        Solve(locations, n, cover);
    }

    static void Solve(int[] locations, int n, int range)
    {
        int[] map = new int[locations.Max()];
        for (int i = 0; i < n; ++i)
        {
            map[locations[i] - 1] = 1;
        }

        int result = 0;
        for (int i = 0; i < map.Length; ++i)
        {
            if (map[i] == 1)
            {
                bool isValidIndex = i + range < map.Length;
                if (isValidIndex && map[i + range] == 1)
                {
                    i += (2 * range);
                    result++;
                }
                else
                {
                    int startIndex = Math.Min(i + range, map.Length) - 1;
                    for (int j = startIndex; j >= i; --j)
                    {
                        if (map[j] == 1)
                        {
                            i = j + range;
                            result++;
                        }
                    }
                }
            }
        }

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

    public int[] NextArrInt => Array.ConvertAll(input.ReadLine().Split(), int.Parse);

    public void Close() => input.Close();
}
