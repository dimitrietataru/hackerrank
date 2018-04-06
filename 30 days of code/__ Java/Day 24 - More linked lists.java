/**
 *              MORE LINKED LISTS | JAVA
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 24
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            Node linkedList = null;

            int nodes = scan.nextInt();
            while (nodes-- > 0) {
                int data = scan.nextInt();
                linkedList = insert(linkedList, data);
            }

            linkedList = removeDuplicates(linkedList);
            printLinkedList(linkedList);
        }
        scan.close();
    }

    private static Node insert(Node linkedList, int data) {
        Node temp = new Node(data);

        if (linkedList == null) {
            linkedList = temp;
        } else if (linkedList.next == null) {
            linkedList.next = temp;
        } else {
            Node start = linkedList;
            while (start.next != null) {
                start = start.next;
            }
            start.next = temp;
        }

        return linkedList;
    }

    private static Node removeDuplicates(Node linkedList) {
        if (linkedList == null) {
            return null;
        }

        Node temp = linkedList;
        while (temp.next != null) {
            if (temp.data == temp.next.data) {
                temp.next = temp.next.next;
            }
            else {
                temp = temp.next;
            }
        }

        return linkedList;
    }
    
    private static void printLinkedList(Node linkedList) {
        Node start = linkedList;
        while (start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }
}

class Node {
    Node next;
    int data;

    Node(int data) {
        this.data = data;
        next = null;
    }
}
