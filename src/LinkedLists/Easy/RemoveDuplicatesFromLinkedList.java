package LinkedLists.Easy;

public class RemoveDuplicatesFromLinkedList {

    public static void main(String[] args) {

        Node n9 = new Node(5, null);
        Node n8 = new Node(5, n9);
        Node n7 = new Node(4, n8);
        Node n6 = new Node(4, n7);
        Node n5 = new Node(4, n6);
        Node n4 = new Node(3, n5);
        Node n3 = new Node(2, n4);
        Node n2 = new Node(1, n3);
        Node n1 = new Node(1, n2);

        printLinkedList(n1);

        Node head = removeDups(n1);

        printLinkedList(head);

    }

    public static Node removeDups(Node head) {

        Node current = head, nextDiff = null;

        while (current != null) {

            nextDiff = current.next;

            while (nextDiff != null && current.value == nextDiff.value) {

                nextDiff = nextDiff.next;

            }

            current.next = nextDiff;
            current = current.next;

        }

        return head;

    }

    public static void printLinkedList(Node node) {

        while (node != null) {

            System.out.print(node.value + " --> ");
            node = node.next;

        }

        System.out.println();

    }

}
