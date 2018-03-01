/**
 *              07 | JAVA VISITOR PATTERN
 * Domain       JAVA
 * Sub domain   ADVANCED
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    private static int[] values;
    private static Color[] colors;
    private static HashMap<Integer, HashSet<Integer>> map;

    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }

    private static Tree solve() {
        Scanner scan = new Scanner(System.in);
        int nodeCount = scan.nextInt();

        values = new int[nodeCount];
        colors = new Color[nodeCount];
        map = new HashMap<>(nodeCount);
        for (int i = 0; i < nodeCount; ++i) {
            values[i] = scan.nextInt();
        }

        for (int i = 0; i < nodeCount; ++i) {
            colors[i] = (scan.nextInt() == 0) ? Color.RED : Color.GREEN;
        }

        for (int i = 0; i < nodeCount - 1; ++i) {
            int u = scan.nextInt();
            int v = scan.nextInt();

            HashSet<Integer> uNeighbors = map.get(u);
            if (uNeighbors == null) {
                uNeighbors = new HashSet<>();
                map.putIfAbsent(u, uNeighbors);
            }
            uNeighbors.add(v);
        }
        scan.close();

        if (nodeCount == 1) {
            return new TreeLeaf(values[0], colors[0], 0);
        }

        TreeNode root = new TreeNode(values[0], colors[0], 0);
        addChildren(root, 1);
        return root;
    }

    private static void addChildren(TreeNode parent, Integer parentNum) {
        for (Integer treeNum : map.get(parentNum)) {

            /* Add child */
            HashSet<Integer> grandChildren = map.get(treeNum);
            boolean childHasChild = (grandChildren != null && !grandChildren.isEmpty());
            Tree currentTree;
            if (childHasChild) {
                currentTree = new TreeNode(values[treeNum-1], colors[treeNum-1], parent.getDepth()+1);
            } else {
                currentTree = new TreeLeaf(values[treeNum-1], colors[treeNum-1], parent.getDepth()+1);
            }
            parent.addChild(currentTree);

            if (currentTree instanceof TreeNode) {
                addChildren((TreeNode) currentTree, treeNum);
            }
        }
    }
}

enum Color {
    RED, GREEN
}

abstract class Tree {
    private int value;
    private Color color;
    private int depth;

    Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    int getValue() {
        return value;
    }

    Color getColor() {
        return color;
    }

    int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {
    private ArrayList<Tree> children = new ArrayList<>();

    TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {
    TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis {
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);
}

class SumInLeavesVisitor extends TreeVis {
    private int result = 0;

    public int getResult() {
        return result;
    }

    public void visitNode(TreeNode node) {}

    public void visitLeaf(TreeLeaf leaf) {
        result += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    private long result = 1;
    private final int Modulo = 1000000007;

    public int getResult() {
        return (int) result;
    }

    public void visitNode(TreeNode node) {
        if (node.getColor() == Color.RED) {
            result = (result * node.getValue()) % Modulo;
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.RED) {
            result = (result * leaf.getValue()) % Modulo;
        }
    }
}

class FancyVisitor extends TreeVis {
    private int nonLeafEvenDepthSum = 0;
    private int greenLeavesSum = 0;

    public int getResult() {
        return Math.abs(nonLeafEvenDepthSum - greenLeavesSum);
    }

    public void visitNode(TreeNode node) {
        nonLeafEvenDepthSum += (node.getDepth() % 2 == 0) ? node.getValue() : 0;
    }

    public void visitLeaf(TreeLeaf leaf) {
        greenLeavesSum += (leaf.getColor() == Color.GREEN) ? leaf.getValue() : 0;
    }
}