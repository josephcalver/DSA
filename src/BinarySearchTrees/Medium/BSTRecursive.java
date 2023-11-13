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

        } else if (value > node.value) {

            node.right = remove(node.right, value);

        } else { // node.value == value

            if (node.left != null && node.right != null) { // 1. Node has 2 children

                int min = getMin(node.right);

                node.value = min;

                node.right = remove(node.right, min);

                return node;

            } else if (node.left != null) { // 2a. Node has left child

                return node.left;

            } else if (node.right != null) { // 2b. Node has right child

                return node.right;

            } else { // 3. Node has no children

                return null;

            }

        }

        return node;

    }

    public BSTRecursive remove2(int value) {

        remove2(null, value);

        return this;

    }

    //    Alternative approach that prevents deleting root node of single-node tree
    public void remove2(BSTRecursive parent, int value) {

        BSTRecursive current = this;

        if (value < current.value) {

            current.left.remove(this, value);

        } else if (value > current.value) {

            current.right.remove(this, value);

        } else {

            if (current.left != null && current.right != null) {

                int min = getMin(current.right);

                current.value = min;

                current.right.remove(this, min);

            } else if (parent == null) { // different approach for single child when current node == root (i.e. parent == null)

                if (current.left != null) {

                    current.value = current.left.value;
                    current.right = current.left.right;
                    current.left = current.left.left;

                } else if (current.right != null) {

                    current.value = current.right.value;
                    current.left = current.right.left;
                    current.right = current.right.right;

                } else {

                    // this is a single-node tree; do nothing

                }

            } else if (current == parent.left) {

                parent.left = current.left != null ? current.left : current.right;

            } else if (current == parent.right) {

                parent.right = current.left != null ? current.left : current.right;

            }

        }

    }

    public int getMin(BSTRecursive node) {

        return node.left == null ? node.value : getMin(node.left);

    }

}