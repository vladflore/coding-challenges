public class LinkedList<T> {
    public LinkedListNode head;

    public void insertNodeAtHead(LinkedListNode node) {
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }
}
