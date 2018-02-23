/**
 *              SCOPE | C#
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 14
 */

using System;
using System.IO;
using System.Linq;

class Program
{
    //static TextReader read = Console.In;
    static StreamReader read = new StreamReader("input.txt");

    static void Main(string[] args)
    {
        int n = int.Parse(read.ReadLine());
        int[] array = read.ReadLine().Split(' ').Select(x => Convert.ToInt32(x)).ToArray();
        read.Close();

        Difference difference = new Difference(array);
        difference.ComputeDifference();
        Console.WriteLine(difference.maximumDifference);
    }
}

class Difference
{
    private int[] Elements { get; set; }
    public int maximumDifference;

    public Difference(int[] elements)
    {
        Elements = elements;
    }

    public void ComputeDifference()
    {
        maximumDifference = int.MinValue;
        for (int i = 0; i < Elements.Length - 1; ++i)
        {
            for (int j = i + 1; j < Elements.Length; ++j)
            {
                int difference = Math.Abs(Elements[i] - Elements[j]);
                maximumDifference = (difference > maximumDifference) ? difference : maximumDifference;
            }
        }
    }
}