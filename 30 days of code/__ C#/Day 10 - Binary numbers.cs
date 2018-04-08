/**
 *              BINARY NUMBERS | C#
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 10
 */

using System;
using System.Collections.Generic;
using System.IO;

class Program
{
    //static TextReader read = Console.In;
    static StreamReader read = new StreamReader("input.txt");

    static void Main(string[] args)
    {
        int n = int.Parse(read.ReadLine());
        read.Close();

        BinaryNumbers(n);
    }

    private static void BinaryNumbers(int n)
    {
        List<int> byteList = IntToBinary(n);
        int currentCount = 0;
        int result = 0;

        foreach(int i in byteList)
        {
            currentCount = (i == 1) ? (currentCount + 1) : 0;
            result = (currentCount > result) ? currentCount : result;
        }

        Console.WriteLine(result);
    }

    private static List<int> IntToBinary(int n)
    {
        List<int> byteList = new List<int>();
        while (n > 0)
        {
            int remainder = n % 2;
            n /= 2;
            byteList.Add(remainder);
        }

        return byteList;
    }
}