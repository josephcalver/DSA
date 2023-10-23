package LinkedLists.Medium;

public class DoublyLinkedList {

    public Node head;
    public Node tail;

    //    O(1) time | O(1) space
    public void setHead(Node node) {

        if (head == null) {

            head = node;
            tail = node;

        } else {

            insertBefore(head, node);

        }

    }


    //    O(1) time | O(1) space
    public void setTail(Node node) {

        if (tail == null) {

            setHead(node);

        } else {

            insertAfter(tail, node);

        }

    }

    //    O(1) time | O(1) space
    public void insertBefore(Node node, Node nodeToInsert) {

        if (nodeToInsert == head && nodeToInsert == tail)
            return; // node to insert is the only node already in a single-node list

        remove(nodeToInsert); // defensive call to remove node in case it's already in the list and needs "moving"

        nodeToInsert.prev = node.prev;
        nodeToInsert.next = node;

        if (nodeToInsert.prev == null) {

            head = nodeToInsert;

        } else {

            node.prev.next = nodeToInsert;

        }

        node.prev = nodeToInsert;

    }

//    O(1) time | O(1) space

    public void insertAfter(Node node, Node nodeToInsert) {

        if (nodeToInsert == head && nodeToInsert == tail)
            return; // no point inserting node after itself (existing node in single-node list)

        remove(nodeToInsert);

        nodeToInsert.next = node.next;
        nodeToInsert.prev = node;

        if (nodeToInsert.next == null) { // newly inserted node is now the tail

            tail = nodeToInsert;

        } else {

            node.next.prev = nodeToInsert;

        }

        node.next = nodeToInsert;

    }

    //    O(p) time | O(1) space
    public void insertAtPosition(int position, Node nodeToInsert) {

        if (position == 1) {

            setHead(nodeToInsert);

            return;

        }

        Node node = head;
        int currentPosition = 1;

        while (node != null && currentPosition != position) {

            node = node.next;
            currentPosition++;

        }

        if (node != null) { // check we haven't dropped off the end

            insertBefore(node, nodeToInsert);

        } else { // position provided was too high; just stick it on the end

            setTail(nodeToInsert);

        }

    }

    //    O(n) time | O(n) space
    public void removeNodesWithValue(int value) {

        Node current = head, next;

        while (current != null) {

            next = current.next; // keep track of next node so we can continue iterating through the list if current node is removed

            if (current.value == value) {

                remove(current);

            }

            current = next;

        }

    }

    //    O(1) time | O(1) space
    public void remove(Node node) {

        // update the head/tail refs, if necessary
        if (node == head) head = head.next;
        if (node == tail) tail = tail.prev;

        // update the previous and next nodes' references
        if (node.prev != null) node.prev.next = node.next;
        if (node.next != null) node.next.prev = node.prev;

        // then update the node itself
        node.prev = null;
        node.next = null;

    }

    //    O(n) time | O(1) space
    public boolean containsNodeWithValue(int value) {

        Node current = head;

        while (current != null) {

            if (current.value == value) return true;

            current = current.next;

        }

        return false;

    }

    //    O(n) time | O(1) space
    public void print() {

        if (head == null) {

            System.out.println("List is empty!");

            return;

        }

        Node current = head;

        while (current != null) {

            System.out.print(current.value);

            if (current != tail) {

                System.out.print(" <=> ");

            }

            current = current.next;

        }

        System.out.println();

    }

}
