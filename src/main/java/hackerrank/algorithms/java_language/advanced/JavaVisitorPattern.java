package hackerrank.algorithms.java_language.advanced;

import java.util.*;

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
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
    int leafs = 0;

    public int getResult() {
        return leafs;
    }

    public void visitNode(TreeNode node) {
    }

    public void visitLeaf(TreeLeaf leaf) {
        leafs += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    public int getResult() {
        //implement this
        return 1;
    }

    public void visitNode(TreeNode node) {
        //implement this
    }

    public void visitLeaf(TreeLeaf leaf) {
        //implement this
    }
}

class FancyVisitor extends TreeVis {
    public int getResult() {
        //implement this
        return 0;
    }

    public void visitNode(TreeNode node) {
        //implement this
    }

    public void visitLeaf(TreeLeaf leaf) {
        //implement this
    }
}

public class JavaVisitorPattern {

    private static int nodeValues[];
    private static Color nodeColors[];
    private static Map<Integer, Set<Integer>> nodesMap = new HashMap<>();

    public static Tree solve() {
        Scanner in = new Scanner(System.in);

        int numberOfNodes = in.nextInt();

        nodeValues = new int[numberOfNodes];
        for (int index = 0; index < numberOfNodes; index++) {
            nodeValues[index] = in.nextInt();
        }

        nodeColors = new Color[numberOfNodes];
        for (int index = 0; index < numberOfNodes; index++) {
            nodeColors[index] = (in.nextInt() == 0) ? Color.RED : Color.GREEN;
        }

        Tree rootNode;
        if (numberOfNodes == 1) {
            rootNode = new TreeLeaf(nodeValues[0], nodeColors[0], 0);
        } else {
            System.out.println("Adding edges");
            for (int index = 0; index < numberOfNodes - 1; index++) {
                int ui = in.nextInt();
                int vi = in.nextInt();
            }
        }

        return rootNode;
    }

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
}
