package BinaryTrees.Easy;

import BinarySearchTrees.Node;

import java.util.ArrayList;
import java.util.List;

public class BranchSums {

    public static void main(String[] args) {

        Node root = buildBinaryTree();

        List<Integer> branchSums = branchSums(root);

        System.out.println(branchSums);

    }

    public static List<Integer> branchSums(Node root) {

        List<Integer> branchSums = new ArrayList<>();

        branchSums(root, 0, branchSums);

        return branchSums;

    }

    public static void branchSums(Node node, int runningSum, List<Integer> sums) {

        if (node == null) return;

        runningSum += node.value;

        if (node.left == null && node.right == null) {

            sums.add(runningSum);

        } else {

            branchSums(node.left, runningSum, sums);

            branchSums(node.right, runningSum, sums);

        }

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
        Node node10 = new Node(10);

        node1.setLeft(node2);
        node1.setRight(node3);

        node2.setLeft(node4);
        node2.setRight(node5);

        node3.setLeft(node6);
        node3.setRight(node7);

        node4.setLeft(node8);
        node4.setRight(node9);

        node5.setLeft(node10);

        return node1;

    }

}
