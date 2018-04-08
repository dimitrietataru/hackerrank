/**
 *              BINARY SEARCH TREES | C#
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 22
 */

using System;
using System.IO;

class Program
{
    static StreamReader read = new StreamReader("input.txt");

    static void Main(string[] args)
    {
        Tree myTree = new Tree();
        Node root = null;

        int totalNodes = int.Parse(read.ReadLine());
        while (totalNodes-- > 0)
        {
            int data = int.Parse(read.ReadLine());
            root = myTree.Insert(root, data);
        }
        read.Close();

        Console.WriteLine(myTree.GetHeight(root));
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
        Left = Right = null;
    }
}