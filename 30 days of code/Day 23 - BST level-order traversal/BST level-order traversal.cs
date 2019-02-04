/**
 *              BST LEVEL-ORDER TRAVERSAL | C#
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 23
*/

using System;
using System.Collections.Generic;
using System.IO;

class Program
{
    static void Main(string[] args)
    {
        var reader = new InputReader(false);
        int totalNodes = reader.NextInt;
        Node tree = null;

        while (totalNodes-- > 0)
        {
            int data = reader.NextInt;
            tree = Insert(tree, data);
        }

        reader.Close();

        LevelOrder(tree);
    }

    static Node Insert(Node binaryTree, int data)
    {
        if (binaryTree == null)
        {
            return new Node(data);
        }

        Node tempNode;
        if (data <= binaryTree.Data)
        {
            tempNode = Insert(binaryTree.Left, data);
            binaryTree.Left = tempNode;
        }
        else
        {
            tempNode = Insert(binaryTree.Right, data);
            binaryTree.Right = tempNode;
        }

        return binaryTree;
    }

    static void LevelOrder(Node binaryTree)
    {
        var queue = new Queue<Node>();

        if (binaryTree != null)
        {
            queue.Enqueue(binaryTree);

            while (!queue.Count.Equals(0))
            {
                var node = queue.Dequeue();
                Console.Write($"{node.Data} ");

                if (node.Left != null)
                {
                    queue.Enqueue(node.Left);
                }
                if (node.Right != null)
                {
                    queue.Enqueue(node.Right);
                }
            }
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
