/**
 *              BINARY SEARCH TREES | C#
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 22
 */

using System;
using System.IO;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(false);
        int totalNodes = reader.NextInt;

        Node root = null;
        Tree tree = new Tree();

        while (totalNodes-- > 0)
        {
            int data = reader.NextInt;
            root = tree.Insert(root, data);
        }
        reader.Close();

        Console.WriteLine(tree.GetHeight(root));
    }
}

class Tree
{
    public Node Insert(Node root, int data)
    {
        if (root == null)
        {
            return new Node(data);
        }
        else
        {
            if (data < root.Data)
            {
                root.Left = Insert(root.Left, data);
            }
            else
            {
                root.Right = Insert(root.Right, data);
            }

            return root;
        }
    }

    public int GetHeight(Node root)
    {
        if (root == null)
        {
            return -1;
        }
        else
        {
            return 1 + Math.Max(GetHeight(root.Left), GetHeight(root.Right));
        }
    }
}

class Node
{
    public Node Left { get; set; }
    public Node Right { get; set; }
    public int Data { get; set; }

    public Node(int data)
    {
        Data = data;
        Left = null;
        Right = null;
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
