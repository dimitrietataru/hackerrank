using System;
using System.IO;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(true);

        int n = reader.NextInt;
        int[] array = reader.NextArrInt;

        Solve(array, n);

        reader.Close();
    }

    static void Solve(int[] array, int n)
    {
        int positiveCount = 0;
        int negativeCount = 0;
        int zeroCount = 0;

        foreach (int number in array)
        {
            if (number > 0)
            {
                positiveCount++;
            }
            else if (number < 0)
            {
                negativeCount++;
            }
            else
            {
                zeroCount++;
            }
        }
        
        Console.WriteLine(((double)positiveCount / n).ToString("0.000000"));
        Console.WriteLine(((double)negativeCount / n).ToString("0.000000"));
        Console.WriteLine(((double)zeroCount / n).ToString("0.000000"));
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
