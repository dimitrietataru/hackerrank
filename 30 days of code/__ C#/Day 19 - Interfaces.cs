/**
 *              INTERFACES | C#
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 19
 */

using System;
using System.IO;

class Program
{
    //static TextReader read = Console.In;
    static StreamReader read = new StreamReader("input.txt");

    static void Main(string[] args)
    {
        int n = Int32.Parse(read.ReadLine());
        read.Close();

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