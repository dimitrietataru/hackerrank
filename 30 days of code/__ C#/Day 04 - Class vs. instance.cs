/**
 *              CLASS VS. INSTANCE | C#
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 04
 */

using System;
using System.IO;

class Program
{
    //static TextReader read = Console.In;
    static StreamReader read = new StreamReader("input.txt");

    static void Main(string[] args)
    {
        int testCases = int.Parse(read.ReadLine());
        while (testCases-- > 0)
        {
            int age = int.Parse(read.ReadLine());
            Person person = new Person(age);
            person.AmIOld();
            for(int i = 0; i < 3; ++i)
            {
                person.YearPasses();
            }
            person.AmIOld();
            Console.WriteLine();
        }
        read.Close();
    }
}

class Person
{
    private int Age { get; set; }

    public Person(int initialAge)
    {
        if (initialAge < 0)
        {
            Console.WriteLine("Age is not valid, setting age to 0.");
            Age = 0;
        }
        else
        {
            Age = initialAge;
        }
    }

    public void AmIOld()
    {
        if (Age < 13)
        {
            Console.WriteLine("You are young.");
        }
        else if (Age < 18)
        {
            Console.WriteLine("You are a teenager.");
        }
        else
        {
            Console.WriteLine("You are old.");
        }
    }

    public void YearPasses()
    {
        Age++;
    }
}