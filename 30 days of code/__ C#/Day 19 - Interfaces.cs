/**
 *              INTERFACES | C#
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 19
 */

using System;
using System.IO;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(false);
        int n = reader.NextInt;
        reader.Close();

        IAdvancedArithmetic calculator = new Calculator();
        int sum = calculator.DivisorSum(n);

        Console.WriteLine("I implemented: " + calculator.GetType().GetInterfaces()[0].Name);
        Console.WriteLine(sum);
    }
}

interface IAdvancedArithmetic
{
    int DivisorSum(int n);
}

class Calculator : IAdvancedArithmetic
{
    public int DivisorSum(int n)
    {
        int sum = n;

        for (int i = 1; i <= n / 2; ++i)
        {
            sum += (n % i == 0) ? i : 0;
        }

        return sum;
    }
}

class InputReader
{
    private TextReader input;

    public InputReader(bool fromFile)
    {
        input = fromFile ? new StreamReader("input.txt") : Console.In;
    }

    public string NextLine => input.ReadLine();

    public int NextInt => int.Parse(NextLine);

    public void Close() => input.Close();
}
