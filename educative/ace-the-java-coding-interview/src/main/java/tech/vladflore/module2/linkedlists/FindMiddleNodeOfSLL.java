package tech.vladflore.module2.linkedlists;

public class FindMiddleNodeOfSLL {

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.insertAtEnd(1);
        list.insertAtEnd(2);

        list.insertAtEnd(123);
        list.insertAtEnd(101);
        list.insertAtEnd(61);
        list.print();
        System.out.println("Middle element is : " + findMiddle(list));
        list = new SinglyLinkedList<>();
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.print();
        System.out.println("Middle element is : " + findMiddle(list));

    }

    private static Integer findMiddle(final SinglyLinkedList<Integer> list) {
        if (list.isEmpty()) {
            return null;
        }
        SinglyLinkedList.Node<Integer> current = list.head;
        SinglyLinkedList.Node<Integer> middle = list.head;

        while (current != null && middle != null && current.next != null) {
            current = current.next.next;
            if (current != null) {
                middle = middle.next;
            }
        }
        return middle.data;
    }

}
