package tech.vladflore.module2.linkedlists;

class ReverseSLL {

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        for (int i = 0; i < 15; i += 2) {
            list.insertAtEnd(i);
        }
        System.out.print("Before ");
        list.print();
        reverse(list);
        System.out.print("After ");
        list.print();
    }

    public static <T> void reverse(SinglyLinkedList<T> sll) {
        SinglyLinkedList.Node<T> previous = null;
        SinglyLinkedList.Node<T> current = sll.head;
        SinglyLinkedList.Node<T> nextTo;

        while (current != null) {
            nextTo = current.next;
            current.next = previous;
            previous = current;
            current = nextTo;
        }
        // at this point previous points to the last element in the sll
        sll.head = previous;
    }
}