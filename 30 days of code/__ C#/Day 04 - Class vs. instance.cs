/**
 *              CLASS VS. INSTANCE | C#
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 04
 */

using System;
using System.IO;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(false);
        var testCases = reader.NextInt;

        while (testCases-- > 0)
        {
            int age = reader.NextInt;
            var person = new Person(age);
            person.AmIOld();
            
            for (int i = 0; i < 3; ++i)
            {
                person.YearPasses();
            }

            person.AmIOld();
            Console.WriteLine();
        }

        reader.Close();
    }
}

class Person
{
    private int age;

    public Person(int initialAge)
    {
        if (initialAge < 0)
        {
            Console.WriteLine("Age is not valid, setting age to 0.");
            age = 0;
        }
        else
        {
            age = initialAge;
        }
    }

    public void AmIOld()
    {
        if (age < 13)
        {
            Console.WriteLine("You are young.");
        }
        else if (age < 18)
        {
            Console.WriteLine("You are a teenager.");
        }
        else
        {
            Console.WriteLine("You are old.");
        }
    }

    public void YearPasses() => age++;
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
