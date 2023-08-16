package LinkedLists.Easy;

import static LinkedLists.Easy.RemoveDuplicatesFromLinkedList.printLinkedList;

public class MiddleNode {

    public static void main(String[] args) {

        Node n9 = new Node(9, null);
        Node n8 = new Node(8, n9);
        Node n7 = new Node(7, n8);
        Node n6 = new Node(6, n7);
        Node n5 = new Node(5, n6);
        Node n4 = new Node(4, n5);
        Node n3 = new Node(3, n4);
        Node n2 = new Node(2, n3);
        Node n1 = new Node(1, n2);

        printLinkedList(n1);

        Node middle = middleNode(n1);

        System.out.println(middle.value);

    }

//    O(n) time | O(1) space

    public static Node middleNode(Node root) {

        Node fast = root, slow = root;

        while (fast != null && fast.next != null) {

            fast = fast.next.next;
            slow = slow.next;

        }

        return slow;

    }

}
