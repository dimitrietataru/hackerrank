/**
 *              BST LEVEL-ORDER TRAVERSAL | JAVA
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 23
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            Node binaryTree = null;
            int nodes = scan.nextInt();
            while (nodes-- > 0) {
                int data = scan.nextInt();
                binaryTree = insert(binaryTree, data);
            }
            levelOrder(binaryTree);
        }
        scan.close();
    }

    private static Node insert(Node binaryTree, int data) {
        if (binaryTree == null) {
            return new Node(data);
        }

        Node tempNode;
        if (data <= binaryTree.data) {
            tempNode = insert(binaryTree.left, data);
            binaryTree.left = tempNode;
        }
        else {
            tempNode = insert(binaryTree.right, data);
            binaryTree.right = tempNode;
        }
        return binaryTree;
    }

    private static void levelOrder(Node binaryTree){
        Deque<Node> queue = new ArrayDeque<>();
        if (binaryTree != null) {
            queue.add(binaryTree);
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                System.out.print(node.data + " ");

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
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
