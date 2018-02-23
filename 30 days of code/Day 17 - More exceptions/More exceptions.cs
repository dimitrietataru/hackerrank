/**
 *              MORE EXCEPTIONS | C#
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 17
 */

using System;
using System.IO;

class Program
{
    //static TextReader read = Console.In;
    static StreamReader read = new StreamReader("input.txt");

    static void Main(string[] args)
    {
        Calculator calculator = new Calculator();
        int queries = Int32.Parse(read.ReadLine());
        while (queries-- > 0)
        {
            string[] line = read.ReadLine().Split(' ');
            int n = int.Parse(line[0]);
            int p = int.Parse(line[1]);
            try
            {
                int answer = calculator.Power(n, p);
                Console.WriteLine(answer);
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
            }
        }
        read.Close();
    }
}

class Calculator
{
    public int Power(int n, int p)
    {
        if (n < 0 || p < 0)
        {
            throw new Exception("n and p should be non-negative");
        }
        return (int)Math.Pow(n, p);
    }
}