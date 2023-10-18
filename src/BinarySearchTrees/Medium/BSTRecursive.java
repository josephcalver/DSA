package BinarySearchTrees.Medium;

public class BSTRecursive {

    public int value;
    public BSTRecursive left;
    public BSTRecursive right;

    public BSTRecursive(int value) {

        this.value = value;

    }

    public BSTRecursive insert(int value) {

        return insert(this, value);

    }

    public BSTRecursive insert(BSTRecursive node, int value) {

        if (node == null) return new BSTRecursive(value);

        if (value < node.value) {

            node.left = insert(node.left, value);

        } else {

            node.right = insert(node.right, value);

        }

        return node;

    }

    public boolean contains(int value) {

        return contains(this, value);

    }

    public boolean contains(BSTRecursive node, int value) {

        if (node == null) return false;

        if (node.value == value) {

            return true;

        } else if (value < node.value) {

            return contains(node.left, value);

        } else {

            return contains(node.right, value);

        }

    }

    public BSTRecursive remove(int value) {

        return remove(this, value);

    }

    public BSTRecursive remove(BSTRecursive node, int value) {

        if (node == null) return node;

        if (value < node.value) {

            node.left = remove(node.left, value);

        } else  if (value > node.value ) {

            node.right = remove(node.right, value);

        } else { // node.value == value

            if (node.left == null && node.right == null) { // 1. Node has no children

                return null;

            } else if (node.left != null && node.right == null) { // 2a. Node has left child

                return node.left;

            } else if (node.right != null && node.left == null) { // 2b. Node has right child

                return node.right;

            } else { // 3. Node has two children

                int min = getMin(node.right);

                node.value = min;

                node.right = remove(node.right, min);

                return node;

            }

        }

        return node;

    }

    public int getMin(BSTRecursive node) {

        return node.left == null ? node.value : getMin(node.left);

    }

}