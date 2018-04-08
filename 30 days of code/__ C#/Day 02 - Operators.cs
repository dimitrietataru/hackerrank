/**
 *              OPERATORS | C#
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 02
 */

using System;
using System.Globalization;
using System.IO;

class Program
{
    //static TextReader read = Console.In;
    static StreamReader read = new StreamReader("input.txt");

    static void Main(string[] args)
    {
        double mealCost = Double.Parse(read.ReadLine(), CultureInfo.InvariantCulture);
        int tipPercent = int.Parse(read.ReadLine());
        int taxPercent = int.Parse(read.ReadLine());
        read.Close();

        double tip = (mealCost * tipPercent) / 100;
        double tax = (mealCost * taxPercent) / 100;
        int totalCost = (int)Math.Round(mealCost + tip + tax);

        Console.WriteLine("The total meal cost is " + totalCost + " dollars.");
    }
}