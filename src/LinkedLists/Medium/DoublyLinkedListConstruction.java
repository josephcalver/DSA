package LinkedLists.Medium;

public class DoublyLinkedListConstruction {

    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();

        Node root = new Node(1);
        list.setHead(root);

        Node node3 = new Node(3);
        list.insertAfter(root, node3);

        Node node2 = new Node(2);
        list.insertBefore(node3, node2);

        list.print();

        Node node4 = new Node(4);
        list.setTail(node4);

        Node node0 = new Node(0);
        list.insertBefore(root, node0);

        Node node5 = new Node(5);
        list.insertAfter(node4, node5);

        list.print();

        list.remove(node0);

        list.print();

        list.insertAtPosition(1, node0);

        Node node7 = new Node(7);
        list.insertAtPosition(1000, node7);

        Node node6 = new Node(6);
        list.insertAtPosition(7, node6);

        list.print();

        list.insertAtPosition(1, node7);
        list.insertAtPosition(3, node7);

        list.print();

        System.out.println(list.containsNodeWithValue(5));
        System.out.println(list.containsNodeWithValue(8));

        list.removeNodesWithValue(7);

        list.print();

    }

}
