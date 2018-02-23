/**
 *              BINARY SEARCH TREES | JAVA
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 22
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        Tree myTree = new Tree();
        Node root = null;

        int totalNodes = scan.nextInt();
        while (totalNodes-- > 0) {
            int data = scan.nextInt();
            root = myTree.insert(root, data);
        }
        scan.close();

        System.out.println(myTree.getHeight(root));
    }
}

class Tree {
    Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            if (data <= root.data) {
                root.left = insert(root.left, data);
            } else {
                root.right = insert(root.right, data);
            }
            return root;
        }
    }

    int getHeight(Node root) {
        if (root == null) {
            return -1;
        } else {
            return 1 + Math.max(getHeight(root.left), getHeight(root.right));
        }
    }
}

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}