using System;
using System.IO;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(true);
        int n = reader.NextInt;
        long[] sticks = reader.NextArrLong;
        reader.Close();

        Solve(sticks);
    }

    static void Solve(long[] sticks)
    {
        Array.Sort(sticks);

        for (int i = sticks.Length - 1; i >= 2; --i)
        {
            if (sticks[i - 2] + sticks[i - 1] > sticks[i])
            {
                Console.WriteLine($"{sticks[i - 2]} {sticks[i - 1]} {sticks[i]}");
                return;
            }
        }

        Console.WriteLine("-1");
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

    public long[] NextArrLong => Array.ConvertAll(input.ReadLine().Split(), long.Parse);

    public void Close() => input.Close();
}
