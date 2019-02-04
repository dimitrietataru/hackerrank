/**
 *              ABSTRACT CLASSES | C#
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 13
 */

using System;
using System.IO;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(false);

        string title = reader.NextString;
        string author = reader.NextString;
        int price = reader.NextInt;

        reader.Close();

        Book book = new MyBook(title, author, price);
        book.Display();
    }
}

abstract class Book
{
    protected readonly string title;
    protected readonly string author;

    public Book(string title, string author)
    {
        this.title = title;
        this.author = author;
    }

    public abstract void Display();
}

class MyBook : Book
{
    private readonly int price;

    public MyBook(string title, string author, int price)
        : base(title, author)
    {
        this.price = price;
    }

    public override void Display()
    {
        Console.WriteLine("Title: " + title);
        Console.WriteLine("Author: " + author);
        Console.WriteLine("Price: " + price);
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

    public string NextString => NextLine;

    public void Close() => input.Close();
}
