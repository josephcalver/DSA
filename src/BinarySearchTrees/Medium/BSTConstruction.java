package BinarySearchTrees.Medium;

public class BSTConstruction {

    public static void main(String[] args) {

        System.out.println("***** Recursive Approach 1 *****");

        BSTRecursive root = new BSTRecursive(10);

        root.insert(5);
        root.insert(15);
        root.insert(2);
        root.insert(5);
        root.insert(13);
        root.insert(22);
        root.insert(1);
        root.insert(14);

        preOrderTraversal(root);
        System.out.println();

        root.remove(5);
        preOrderTraversal(root);
        System.out.println();

        root.remove(5);
        preOrderTraversal(root);
        System.out.println();

        root.remove(1);
        preOrderTraversal(root);
        System.out.println();

        root.remove(10);
        preOrderTraversal(root);
        System.out.println();

        root.insert(9);
        preOrderTraversal(root);
        System.out.println();

        root.insert(13);
        preOrderTraversal(root);
        System.out.println();

        System.out.println(root.contains(22));
        System.out.println();

        /*****/

        System.out.println("***** Recursive Approach 2 *****");

        BSTRecursive root2 = new BSTRecursive(10);

        root2.insert(5);
        root2.insert(15);
        root2.insert(2);
        root2.insert(5);
        root2.insert(13);
        root2.insert(22);
        root2.insert(1);
        root2.insert(14);

        preOrderTraversal(root2);
        System.out.println();

        root2.remove2(5);
        preOrderTraversal(root2);
        System.out.println();

        root2.remove2(5);
        preOrderTraversal(root2);
        System.out.println();

        root2.remove(1);
        preOrderTraversal(root2);
        System.out.println();

        root2.remove(10);
        preOrderTraversal(root2);
        System.out.println();

        root2.insert(9);
        preOrderTraversal(root2);
        System.out.println();

        root2.insert(13);
        preOrderTraversal(root2);
        System.out.println();

        System.out.println(root2.contains(22));
        System.out.println();

        /*****/

        System.out.println("***** Iterative Approach 1 *****");

        BSTIterative root3 = new BSTIterative(10);

        root3.insert(5);
        root3.insert(15);
        root3.insert(2);
        root3.insert(5);
        root3.insert(13);
        root3.insert(22);
        root3.insert(1);
        root3.insert(14);

        preOrderTraversal(root3);
        System.out.println();

        root3.remove(5);
        preOrderTraversal(root3);
        System.out.println();

        root3.remove(5);
        preOrderTraversal(root3);
        System.out.println();

        root3.remove(1);
        preOrderTraversal(root3);
        System.out.println();

        root3.remove(10);
        preOrderTraversal(root3);
        System.out.println();

        root3.insert(9);
        preOrderTraversal(root3);
        System.out.println();

        root3.insert(13);
        preOrderTraversal(root3);
        System.out.println();

        System.out.println(root3.contains(22));
        System.out.println();

    }

    public static void preOrderTraversal(BSTRecursive node) {

        if (node == null) return;

        System.out.println(node.value + " --> ");

        preOrderTraversal(node.left);

        preOrderTraversal(node.right);

    }

    public static void preOrderTraversal(BSTIterative node) {

        if (node == null) return;

        System.out.println(node.value + " --> ");

        preOrderTraversal(node.left);

        preOrderTraversal(node.right);

    }

}
