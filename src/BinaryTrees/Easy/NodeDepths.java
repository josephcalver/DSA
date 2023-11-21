package BinaryTrees.Easy;

import BinarySearchTrees.Node;

import java.util.Deque;
import java.util.LinkedList;

public class NodeDepths {

    public static void main(String[] args) {

        Node root = buildBinaryTree();

        int sumDepths = nodeDepthsRecursive(root);
        System.out.println(sumDepths);

        sumDepths = nodeDepthsIterative(root);
        System.out.println(sumDepths);

    }

    public static int nodeDepthsRecursive(Node root) {

        return nodeDepthsRecursive(root, 0);

    }

    public static int nodeDepthsRecursive(Node node, int depth) {

        if (node == null) return 0;

        return depth + nodeDepthsRecursive(node.left, depth + 1) + nodeDepthsRecursive(node.right, depth + 1);

    }

    public static int nodeDepthsIterative(Node root) {

        Deque<Nodule> stack = new LinkedList<>();
        stack.push(new Nodule(root, 0));

        int sumDepths = 0;

        while (!stack.isEmpty()) {

            Nodule nodule = stack.pop();
            Node node = nodule.getNode();

            int depth = nodule.getDepth();
            sumDepths += depth;

            if (node.left != null) stack.push(new Nodule(node.left, depth + 1));
            if (node.right != null) stack.push(new Nodule(node.right, depth + 1));

        }

        return sumDepths;

    }

    public static Node buildBinaryTree() {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);

        node1.setLeft(node2);
        node1.setRight(node3);

        node2.setLeft(node4);
        node2.setRight(node5);

        node3.setLeft(node6);
        node3.setRight(node7);

        node4.setLeft(node8);
        node4.setRight(node9);

        return node1;

    }

}

class Nodule {

    Node node;

    int depth;

    public Nodule(Node node, int depth) {

        this.node = node;
        this.depth = depth;

    }

    public Node getNode() {

        return this.node;

    }

    public int getDepth() {

        return this.depth;

    }

}
