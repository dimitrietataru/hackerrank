using System;
using System.IO;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(true);

        int[] alicePoints = reader.NextArrInt;
        int[] bobPoints = reader.NextArrInt;

        Solve(alicePoints, bobPoints);

        reader.Close();
    }

    static void Solve(int[] a, int[] b)
    {
        int aliceScore = 0;
        int bobScore = 0;

        for (int i = 0; i < a.Length; ++i)
        {
            if (a[i] > b[i])
            {
                aliceScore++;
            }
            else if (a[i] < b[i])
            {
                bobScore++;
            }
        }

        Console.WriteLine($"{aliceScore} {bobScore}");
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
