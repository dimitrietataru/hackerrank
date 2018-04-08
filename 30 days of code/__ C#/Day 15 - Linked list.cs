/**
 *              LINKED LIST | C#
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 15
 */

using System;
using System.IO;

class Program
{
    //static TextReader read = Console.In;
    static StreamReader read = new StreamReader("input.txt");

    static void Main(string[] args)
    {
        Node head = null;
        int n = Int32.Parse(read.ReadLine());
        while (n-- > 0)
        {
            int data = Int32.Parse(read.ReadLine());
            head = Insert(head, data);
        }
        read.Close();

        Display(head);
    }

    private static Node Insert(Node head, int data)
    {
        if (head == null)
        {
            head = new Node(data);
        }
        else
        {
            Node c = head;
            while (c.Next != null)
            {
                c = c.Next;
            }
            c.Next = new Node(data);
        }
        return head;
    }

    private static void Display(Node head)
    {
        Node currentNode = head;
        while (currentNode != null)
        {
            Console.Write(currentNode.Data + " ");
            currentNode = currentNode.Next;
        }
    }
}

class Node
{
    public int Data { get; set; }
    public Node Next { get; set; }

    public Node(int data)
    {
        Data = data;
        Next = null;
    }
}