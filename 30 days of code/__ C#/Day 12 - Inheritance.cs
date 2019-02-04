/**
 *              INHERITANCE | C#
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 12
 */

using System;
using System.IO;
using System.Linq;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(false);
        var line = reader.NextArrString;
        var testScores = reader.NextArrInt;
        reader.Close();

        Student student = new Student(line[0], line[1], int.Parse(line[2]), testScores);
        student.Print();
        Console.WriteLine("Grade: " + student.Calculate());
    }
}

class Person
{
    private readonly string firstName;
    private readonly string lastName;
    private readonly int id;

    public Person(string firstName, string lastName, int id)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public void Print() => Console.WriteLine($"Name: {lastName} {firstName}\nID: {id}";
}

class Student : Person
{
    private int[] testScores;

    public Student(string firstName, string lastName, int id, int[] testScores)
        : base(firstName, lastName, id)
    {
        this.testScores = testScores;
    }

    public char Calculate()
    {
        int total = testScores.Sum();
        int mean = total / testScores.Length;

        switch (mean)
        {
            case int i when i >= 90 && i <= 100:
                return 'O';
            case int i when i >= 80:
                return 'E';
            case int i when i >= 70:
                return 'A';
            case int i when i >= 55:
                return 'P';
            case int i when i >= 40:
                return 'D';
            default:
                return 'T';
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

    public string NextLine => input.ReadLine();

    public int[] NextArrInt => Array.ConvertAll(NextLine.Split(), int.Parse);

    public string[] NextArrString => NextLine.Split();

    public void Close() => input.Close();
}
