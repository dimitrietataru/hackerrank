using System;
using System.Collections.Generic;
using System.IO;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(true);

        string input = reader.NextString;
        var possibleSums = CalculateSums(input);

        int testCases = reader.NextInt;
        while (testCases-- > 0)
        {
            long n = reader.NextLong;

            Console.WriteLine(possibleSums.Contains(n) ? "Yes" : "No");
        }

        reader.Close();
    }

    static HashSet<long> CalculateSums(string input)
    {
        var set = new HashSet<long>();

        for (int i = 0; i < input.Length; ++i)
        {
            long sum = input[i] - 'a' + 1;
            set.Add(sum);

            for (int j = i + 1; j < input.Length && input[i] == input[j]; ++i, ++j)
            {
                sum += input[j] - 'a' + 1;
                set.Add(sum);
            }
        }

        return set;
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

    public long NextLong => long.Parse(input.ReadLine());

    public string NextString => input.ReadLine();

    public void Close() => input.Close();
}
