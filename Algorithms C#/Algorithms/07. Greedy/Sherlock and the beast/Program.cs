using System;
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
            int length = reader.NextInt;
            Solve(length);
        }

        reader.Close();
    }

    static void Solve(int length)
    {
        int fives = 0;
        int threes = 0;

        for (int i = length; i >= 0; --i)
        {
            if (i % 3 == 0 && (length - i) % 5 ==0)
            {
                fives = i;
                threes = length - i;
                break;
            }
        }

        if (fives == 0 && threes == 0)
        {
            Console.WriteLine("-1");
        }
        else
        {
            var fiveTimes = Enumerable.Repeat("5", fives);
            var threeTimes = Enumerable.Repeat("3", threes);

            Console.WriteLine($"{string.Join("", fiveTimes)}{string.Join("", threeTimes)}");
        }
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
