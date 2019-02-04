/**
 *              LINKED LIST | C#
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 15
 */

using System;
using System.IO;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(false);

        Node head = null;
        int n = reader.NextInt;

        while (n-- > 0)
        {
            int data = reader.NextInt;
            head = Insert(head, data);
        }

        reader.Close();

        Display(head);
    }

    private static Node Insert(Node head, int data)
    {
        if (head is null)
        {
            head = new Node(data);
        }
        else
        {
            Node current = head;

            while (current.next != null)
            {
                current = current.next;
            }

            current.next = new Node(data);
        }

        return head;
    }

    private static void Display(Node head)
    {
        Node currentNode = head;
        while (currentNode != null)
        {
            Console.Write($"{currentNode.data} ");
            currentNode = currentNode.next;
        }
    }
}

class Node
{
    public readonly int data;
    public Node next;

    public Node(int data)
    {
        this.data = data;
        next = null;
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

    public void Close() => input.Close();
}
