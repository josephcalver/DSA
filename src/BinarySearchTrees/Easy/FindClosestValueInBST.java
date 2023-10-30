package BinarySearchTrees.Easy;

import BinarySearchTrees.Node;

public class FindClosestValueInBST {

    public static void main(String[] args) {

        Node root = buildBST();

        int closest = closestValueBruteForce(root, 12);
        System.out.println(closest);

        closest = closestValueRecursive(root, 12);
        System.out.println(closest);

        closest = closestValueIterative(root, 12);
        System.out.println(closest);

    }

    public static int closestValueBruteForce(Node node, int target) {

        return closestValueBruteForce(node, target, Integer.MAX_VALUE);

    }

    //    O(n) time | O(log(n)) best, O(n) worst space
    public static int closestValueBruteForce(Node node, int target, int closest) {

        if (node == null) return closest;

        closest = closestValueBruteForce(node.left, target, closest);

        closest = Math.abs(target - node.value) < Math.abs(target - closest) ? node.value : closest;

        closest = closestValueBruteForce(node.right, target, closest);

        return closest;

    }

    public static int closestValueRecursive(Node node, int target) {

        return closestValueRecursive(node, target, Integer.MAX_VALUE);

    }

    //    O(log(n)) best, O(n) worst time | O(log(n)) best, O(n) worst space
    public static int closestValueRecursive(Node node, int target, int closest) {

        if (node == null) return closest;

        closest = Math.abs(target - node.value) < Math.abs(target - closest) ? node.value : closest;

        if (target < node.value) {

            closest = closestValueRecursive(node.left, target, closest);

        } else if (target > node.value) {

            closest = closestValueRecursive(node.right, target, closest);

        } else {

            return closest;

        }

        return closest;

    }

    //    O(log(n)) best, O(n) worst time | O(1) space
    public static int closestValueIterative(Node node, int target) {

        int closest = Integer.MAX_VALUE;

        Node current = node;

        while (current != null) {

            closest = Math.abs(target - current.value) < Math.abs(target - closest) ? current.value : closest;

            if (target < current.value) {

                current = current.left;

            } else {

                current = current.right;

            }

        }

        return closest;

    }

    public static Node buildBST() {

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

}