/**
 *              INHERITANCE | C#
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 12
 */

using System;
using System.IO;

class Program
{
    //static TextReader read = Console.In;
    static StreamReader read = new StreamReader("input.txt");

    static void Main(string[] args)
    {
        string[] line = read.ReadLine().Split(' ');
        string firstName = line[0];
        string lastName = line[1];
        int id = int.Parse(line[2]);
        int scores = int.Parse(read.ReadLine());
        int[] testScores = new int[scores];
        line = read.ReadLine().Split(' ');
        testScores = Array.ConvertAll(line, int.Parse);
        read.Close();

        Student student = new Student(firstName, lastName, id, testScores);
        student.printPerson();
        Console.WriteLine("Grade: " + student.Calculate());
    }
}

class Person
{
    private string FirstName { get; set; }
    private string LastName { get; set; }
    private int Id { get; set; }

    public Person() { }

    public Person(string firstName, string lastName, int id)
    {
        FirstName = firstName;
        LastName = lastName;
        Id = id;
    }

    public void printPerson()
    {
        Console.WriteLine("Name: " + LastName + ", " + FirstName + "\nID: " + Id);
    }
}

class Student : Person
{
    private int[] TestScores { get; set; }

    public Student(String firstName, String lastName, int id, int[] testScores) 
        : base(firstName, lastName, id)
    {
        TestScores = testScores;
    }

    public char Calculate()
    {
        int total = TestScores.Length;
        foreach (int i in TestScores) {
            total += i;
        }

        int mean = total / TestScores.Length;

        if (mean >= 90 && mean <= 100)
        {
            return 'O';
        }
        else if (mean >= 80)
        {
            return 'E';
        }
        else if (mean >= 70)
        {
            return 'A';
        }
        else if (mean >= 55)
        {
            return 'P';
        }
        else if (mean >= 40)
        {
            return 'D';
        }
        else
        {
            return 'T';
        }
    }
}