using System;
using System.IO;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(true);
        int orders = reader.NextInt;
        int[] weights = reader.NextArrInt;
        reader.Close();

        Solve(weights);
    }

    static void Solve(int[] weights)
    {
        Array.Sort(weights);

        int i = 0;
        int result = 1;
        int lastPrice = weights[0];

        while (i < weights.Length)
        {
            if (weights[i] - lastPrice > 4)
            {
                result++;
                lastPrice = weights[i];
            }

            i++;
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

    public int NextInt => int.Parse(input.ReadLine());

    public int[] NextArrInt => Array.ConvertAll(input.ReadLine().Split(), int.Parse);

    public void Close() => input.Close();
}
