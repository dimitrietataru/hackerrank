using System;
using System.IO;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(true);

        string input = reader.NextString;
        Solve(input);

        reader.Close();
    }

    static void Solve(string input)
    {
        var maxIndex = input.Length - 1;
        bool isReduced = false;

        while (!isReduced)
        {
            isReduced = true;
            
            for (int i = 0; i < maxIndex; ++i)
            {
                if (input[i] == input[i + 1])
                {
                    input = input.Substring(0, i) + input.Substring(i + 2);
                    isReduced = false;
                    maxIndex -= 2;
                }
            }
        }

        if (input == string.Empty)
        {
            Console.WriteLine("Empty String");
        }
        else
        {
            Console.WriteLine(input);
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

    public string NextString => input.ReadLine();

    public void Close() => input.Close();
}
