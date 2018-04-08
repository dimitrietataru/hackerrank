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
        {
            int n = scan.nextInt();
            Node linkedList = null;

            while (n-- > 0) {
                int element = scan.nextInt();
                linkedList = insert(linkedList, element);
            }

            display(linkedList);
        }
        scan.close();
    }

    private static Node insert(Node linkedList, int data) {
        if (linkedList == null) {
            linkedList = new Node(data);
        } else {
            Node temp = linkedList;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(data);
        }
        return linkedList;
    }

    private static void display(Node linkedList) {
        Node temp = linkedList;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}

class Node {
    Node next;
    int data;

    Node(int d) {
        this.data = d;
        this.next = null;
    }
}
