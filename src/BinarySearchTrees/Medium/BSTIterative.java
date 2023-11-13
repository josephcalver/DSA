package BinarySearchTrees.Medium;

public class BSTIterative {

    public int value;
    public BSTIterative left;
    public BSTIterative right;

    public BSTIterative(int value) {
        this.value = value;
    }

    public BSTIterative insert(int value) {

        // Write your code here.
        // Do not edit the return statement of this method.

        BSTIterative current = this;

        while (true) {

            if (value < current.value) {

                if (current.left != null) {

                    current = current.left;

                } else {

                    current.left = new BSTIterative(value);

                    break;

                }

            } else {

                if (current.right != null) {

                    current = current.right;

                } else {

                    current.right = new BSTIterative(value);

                    break;

                }


            }


        }

        return this;

    }

    public boolean contains(int value) {

        BSTIterative current = this;

        while (current != null) {

            if (value < current.value) {

                current = current.left;

            } else if (value > current.value) {

                current = current.right;

            } else {

                return true;

            }

        }

        return false;

    }

    public BSTIterative remove(int value) {

        remove(value, null);

        return this;

    }

    public void remove(int value, BSTIterative parent) {

        // Write your code here.
        // Do not edit the return statement of this method.

        BSTIterative current = this;

        while (current != null) {

            if (value < current.value) {

                parent = current;
                current = current.left;

            } else if (value > current.value) {

                parent = current;
                current = current.right;

            } else {

                if (current.left != null && current.right != null) { // 2 child approach applies to any node, including root

                    int successor = current.right.getSuccessor();

                    current.value = successor;

                    current.right.remove(successor, current);

                } else if (parent == null) { // single child approach different for root node

                    if (current.left != null) {

                        current.value = left.value;
                        current.right = current.left.right;
                        current.left = current.left.left;

                    } else if (current.right != null) {

                        current.value = right.value;
                        current.left = current.right.left;
                        current.right = current.right.right;

                    } else {

                        // this is a single-node tree; do nothing

                    }

                } else if (parent.left == current) {

                    parent.left = current.left != null ? current.left : current.right;

                } else if (parent.right == current) {

                    parent.right = current.left != null ? current.left : current.right;

                }

                break; // remember to delete after deletion has occurred!

            }

        }

    }

    public int getSuccessor() {

        if (this.left == null) {

            return this.value;

        }

        return this.left.getSuccessor();

    }

}