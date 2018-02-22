/**
 *              ABSTRACT CLASSES | C#
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 13
 */

using System;
using System.IO;

class Program
{
    //static TextReader read = Console.In;
    static StreamReader read = new StreamReader("input.txt");

    static void Main(string[] args)
    {
        string title = read.ReadLine();
        string author = read.ReadLine();
        int price = int.Parse(read.ReadLine());
        read.Close();

        Book book = new MyBook(title, author, price);
        book.Display();
    }
}

abstract class Book
{
    protected String Title { get; set; }
    protected String Author { get; set; }

    public Book(String title, String author)
    {
        Title = title;
        Author = author;
    }

    public abstract void Display();
}

class MyBook : Book
{
    private int Price { get; set; }

    public MyBook(String title, String author, int price) : base(title, author)
    {
        Price = price;
    }

    public override void Display()
    {
        Console.WriteLine("Title: " + Title);
        Console.WriteLine("Author: " + Author);
        Console.WriteLine("Price: " + Price);
    }
}