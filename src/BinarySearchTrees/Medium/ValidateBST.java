package BinarySearchTrees.Medium;

import BinarySearchTrees.Node;

public class ValidateBST {

    public static void main(String[] args) {

        Node root = buildBinaryTree();

        inOrderTraversal(root);

        boolean isValidTree = validateBst(root);

        System.out.println(isValidTree);

    }

    public static boolean validateBst(Node root) {

        return validateBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }

    public static boolean validateBst(Node node, int min, int max) {

        if (node == null) return true;

        if (node.value < min || node.value >= max) return false;

        return validateBst(node.left, min, node.value) && validateBst(node.right, node.value, max);

    }

    public static Node buildBinaryTree() {

        Node node1 = new Node(10);
        Node node2 = new Node(5);
        Node node3 = new Node(15);
        Node node4 = new Node(2);
        Node node5 = new Node(5);
        Node node6 = new Node(13);
        Node node7 = new Node(22);
        Node node8 = new Node(1);
        Node node9 = new Node(14);

        node1.setLeft(node2);
        node1.setRight(node3);

        node2.setLeft(node4);
        node2.setRight(node5);

        node3.setLeft(node6);
        node3.setRight(node7);

        node4.setLeft(node8);

        node6.setRight(node9);

        return node1;

    }

    public static void inOrderTraversal(Node node) {

        if (node == null) return;

        inOrderTraversal(node.left);

        System.out.println(node.value);

        inOrderTraversal(node.right);

    }

}
