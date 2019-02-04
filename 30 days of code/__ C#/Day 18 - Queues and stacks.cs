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
    static void Main(string[] args)
    {
        var reader = new InputReader(false);
        char[] chars = reader.NextArrChar;
        reader.Close();

        Solution qs = new Solution();

        foreach (char c in chars)
        {
            qs.PushCharacter(c);
            qs.EnqueueCharacter(c);
        }

        bool isPalindrome = true;
        for (int i = 0; i < chars.Length / 2; ++i)
        {
            if (qs.PopCharacter() != qs.DequeueCharacter())
            {
                isPalindrome = false;
                break;
            }
        }

        Console.WriteLine($"The word, {new string(chars)}, is "
            + (isPalindrome ? "a palindrome." : "not a palindrome"));
    }
}

class Solution
{
    private readonly Stack<char> stack;
    private readonly Queue<char> queue;

    public Solution()
    {
        stack = new Stack<char>();
        queue = new Queue<char>();
    }

    public void PushCharacter(char c) => stack.Push(c);

    public void EnqueueCharacter(char c) => queue.Enqueue(c);

    public char PopCharacter() => stack.Pop();

    public char DequeueCharacter() => queue.Dequeue();
}

class InputReader
{
    private TextReader input;

    public InputReader(bool fromFile)
    {
        input = fromFile ? new StreamReader("input.txt") : Console.In;
    }

    public string NextLine => input.ReadLine();

    public char[] NextArrChar => NextLine.Replace(" ", "").ToCharArray();

    public void Close() => input.Close();
}
