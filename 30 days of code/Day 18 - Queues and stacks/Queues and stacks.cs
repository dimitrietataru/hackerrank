/**
 *              QUEUES AND STACKS | C#
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 18
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
        string input = read.ReadLine();
        read.Close();

        QueueStack qs = new QueueStack();
        char[] word = input.ToCharArray();

        foreach (char c in word) {
            qs.PushCharacter(c);
            qs.EnqueueCharacter(c);
        }

        bool isPalindrome = true;
        for (int i = 0; i < word.Length / 2; ++i)
        {
            if (qs.PopCharacter() != qs.DequeueCharacter())
            {
                isPalindrome = false;
                break;
            }
        }

        Console.WriteLine("The word, " + input + ", is "
            + ((isPalindrome) ? "a palindrome." : "not a palindrome."));
    }
}

class QueueStack
{
    private Stack<char> Stack { get; set; }
    private Queue<char> Queue { get; set; }

    public QueueStack()
    {
        Stack = new Stack<char>();
        Queue = new Queue<char>();
    }

    public void PushCharacter(char c)
    {
        Stack.Push(c);
    }

    public void EnqueueCharacter(char c)
    {
        Queue.Enqueue(c);
    }

    public char PopCharacter()
    {
        return Stack.Pop();
    }

    public char DequeueCharacter()
    {
        return Queue.Dequeue();
    }
}