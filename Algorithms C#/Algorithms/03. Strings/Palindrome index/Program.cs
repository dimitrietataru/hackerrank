using System;
using System.IO;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(true);

        int testCases = reader.NextInt;
        while (testCases-- > 0)
        {
            string input = reader.NextString;

            Solve(input);
        }

        reader.Close();
    }

    static void Solve(string input)
    {
        if (IsPalindrome(input))
        {
            Console.WriteLine("-1");
            return;
        }

        int i = 0;
        int j = input.Length - 1;
        while (i <= j)
        {
            if (input[i] == input[j])
            {
                i++;
                j--;
                continue;
            }

            if (IsPalindrome(input, i))
            {
                Console.WriteLine(i);
                return;
            }

            if (IsPalindrome(input, j))
            {
                Console.WriteLine(j);
                return;
            }

            Console.WriteLine("-1");
            return;
        }
    }

    static bool IsPalindrome(string input, int position = -1)
    {
        int i = 0;
        int j = input.Length - 1;

        while (i <= j)
        {
            i += i == position ? 1 : 0;
            j -= j == position ? 1 : 0;

            if (input[i++] != input[j--])
            {
                return false;
            }
        }

        return true;
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

    public string NextString => input.ReadLine();

    public void Close() => input.Close();
}
