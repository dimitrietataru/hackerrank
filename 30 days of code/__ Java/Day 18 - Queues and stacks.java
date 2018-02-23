/**
 *              QUEUES AND STACKS | JAVA
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 18
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        String input = scan.next();
        scan.close();

        QueueStack qs = new QueueStack();
        char[] word = input.toCharArray();

        for (char c : word) {
            qs.pushCharacter(c);
            qs.enqueueCharacter(c);
        }

        boolean isPalindrome = true;
        for (int i = 0; i < word.length / 2; ++i) {
            if (qs.popCharacter() != qs.dequeueCharacter()) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("The word, " + input + ", is "
            + ((isPalindrome) ? "a palindrome." : "not a palindrome."));
    }
}

class QueueStack {
    private Stack<Character> stack;             // FILO
    private Queue<Character> queue;             // FIFO

    QueueStack() {
        stack = new Stack<>();
        queue = new LinkedList<>();
    }

    // Push char to STACK - current char is the first element
    void pushCharacter(char c) {
        stack.push(c);
    }

    // Add char to QUEUE - current char is the last element
    void enqueueCharacter(char c) {
        queue.add(c);
    }

    // Get char, from last to first
    char popCharacter() {
        return stack.pop();
    }

    // Get char, from first to last
    char dequeueCharacter() {
        return queue.poll();
    }
}