package tech.vladflore.module2.linkedlists;

import java.util.HashSet;

public class RemoveDuplicatesFromSSL {

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        for (int i = 1; i <= 8; i++) {
            list.insertAtHead(i);
        }
        // insert the duplicates
        list.insertAtHead(2);
        list.insertAtHead(4);
        list.insertAtHead(1);

        System.out.println("List before deleting duplicates from list :");
        list.print();
        removeDuplicatesWithHashing(list);
        System.out.println("List after deleting duplicates from list :");
        list.print();
    }

    private static void removeDuplicatesWithHashing(SinglyLinkedList<Integer> list) {
        SinglyLinkedList.Node<Integer> prev = list.head;
        SinglyLinkedList.Node<Integer> current = list.head;
        HashSet<Integer> seen = new HashSet<>();
        if (!list.isEmpty() && current.next != null) {
            while (current != null) {
                if (seen.contains(current.data)) {
                    // delete the current node
                    prev.next = current.next;
                } else {
                    seen.add(current.data);
                    prev = current;
                }
                current = current.next;
            }
        }
    }
}
