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
        if (length % 15 == 0)
        {
            var fives = Enumerable.Repeat("5", length);
            Console.WriteLine(string.Join("", fives));
        }
        else if (length % 5 == 0)
        {
            var digits = Enumerable.Repeat("3", length);
            Console.WriteLine(string.Join("", digits));
        }
        else if (length % 3 == 0)
        {
            var digits = Enumerable.Repeat("5", length);
            Console.WriteLine(string.Join("", digits));
        }
        else if (length > 5 && (length - 5) % 3 == 0)
        {
            var fives = Enumerable.Repeat("5", length - 5);
            var threes = Enumerable.Repeat("3", 5);
            Console.WriteLine(string.Join("", fives.Concat(threes)));
        }
        else if (length > 10 && (length - 10) % 3 == 0)
        {
            var fives = Enumerable.Repeat("5", length - 10);
            var threes = Enumerable.Repeat("3", 10);
            Console.WriteLine(string.Join("", fives.Concat(threes)));
        }
        else
        {
            Console.WriteLine("-1");
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
