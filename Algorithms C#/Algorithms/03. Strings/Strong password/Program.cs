using System;
using System.IO;
using System.Linq;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(true);

        int length = reader.NextInt;
        string input = reader.NextString;
        Solve(input);

        reader.Close();
    }

    static void Solve(string input)
    {
        int missing = 0;
        missing += input.IndexOfAny("0123456789".ToArray()) != -1 ? 0 : 1;
        missing += input.IndexOfAny("abcdefghijklmnopqrstuvwxyz".ToArray()) != -1 ? 0 : 1;
        missing += input.IndexOfAny("ABCDEFGHIJKLMNOPQRSTUVWXYZ".ToArray()) != -1 ? 0 : 1;
        missing += input.IndexOfAny("!@#$%^&*()-+".ToArray()) != -1 ? 0 : 1;

        if (missing + input.Length >= 6)
        {
            Console.WriteLine(missing);
        }
        else
        {
            var result = 6 - input.Length;
            Console.WriteLine(result);
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

    public string NextString => input.ReadLine();

    public void Close() => input.Close();
}
