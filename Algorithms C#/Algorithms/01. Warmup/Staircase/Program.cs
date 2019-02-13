using System;
using System.IO;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(true);
        int n = reader.NextInt;
        reader.Close();

        Solve(n);
    }

    static void Solve(int n)
    {
        for (int i = 1; i <= n; ++i)
        {
            for (int j = i; j < n; ++j)
            {
                Console.Write(" ");
            }
                
            for (int h = 0; h < i; ++h)
            {
                Console.Write("#");
            }
                
            Console.WriteLine();
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
