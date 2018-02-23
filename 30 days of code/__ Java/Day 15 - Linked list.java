/**
 *              LINKED LIST | JAVA
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 15
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        int n = scan.nextInt();
        Node head = null;

        while (n-- > 0) {
            int element = scan.nextInt();
            head = insert(head, element);
        }
        scan.close();

        display(head);
    }

    private static Node insert(Node head, int data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node c = head;
            while (c.next != null) {
                c = c.next;
            }
            c.next = new Node(data);
        }
        return head;
    }

    private  static void display(Node head) {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
    }
}

class Node {
    int data;
    Node next;

    Node(int d) {
        this.data = d;
        this.next = null;
    }
}