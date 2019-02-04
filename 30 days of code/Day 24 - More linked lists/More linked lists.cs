/**
 *              MORE LINKED LISTS | C#
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 24
*/

using System;
using System.IO;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(false);
        int totalNodes = reader.NextInt;
        Node linkedList = null;

        while (totalNodes-- > 0)
        {
            int data = reader.NextInt;
            linkedList = Insert(linkedList, data);
        }

        reader.Close();

        linkedList = RemoveDuplicates(linkedList);
        Print(linkedList);
    }

    static Node Insert(Node linkedList, int data)
    {
        var temp = new Node(data);

        if (linkedList == null)
        {
            linkedList = temp;
        }
        else if (linkedList.Next == null)
        {
            linkedList.Next = temp;
        }
        else
        {
            Node start = linkedList;

            while (start.Next != null)
            {
                start = start.Next;
            }

            start.Next = temp;
        }

        return linkedList;
    }

    static Node RemoveDuplicates(Node linkedList)
    {
        if (linkedList == null)
        {
            return null;
        }

        Node temp = linkedList;
        while (temp.Next != null)
        {
            if (temp.Data == temp.Next.Data)
            {
                temp.Next = temp.Next.Next;
            }
            else
            {
                temp = temp.Next;
            }
        }

        return linkedList;
    }

    static void Print(Node linkedList)
    {
        var currentNode = linkedList;

        while (currentNode != null)
        {
            Console.WriteLine($"{currentNode.Data} ");
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
