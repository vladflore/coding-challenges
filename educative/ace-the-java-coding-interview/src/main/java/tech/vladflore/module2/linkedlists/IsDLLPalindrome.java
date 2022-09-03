package tech.vladflore.module2.linkedlists;

public class IsDLLPalindrome {

    public static void main(String[] args) {
        DoublyLinkedList<Integer> list1 = new DoublyLinkedList<>();
        list1.insertAtEnd(1);
        list1.insertAtEnd(2);
        list1.insertAtEnd(2);
        list1.insertAtEnd(1);
        System.out.print("1st ");
        list1.print();
        DoublyLinkedList<Integer> list2 = new DoublyLinkedList<>();
        list2.insertAtEnd(6);
        list2.insertAtEnd(8);
        list2.insertAtEnd(6);
        list2.insertAtEnd(6);
        System.out.print("2nd ");
        list2.print();
        DoublyLinkedList<Integer> list3 = new DoublyLinkedList<>();
        list3.insertAtEnd(1);
        list3.insertAtEnd(2);
        list3.insertAtEnd(1);
        System.out.print("3nd ");
        list3.print();
        System.out.println("Is 1st list a palindrome?  " + isPalindrome(list1));
        System.out.println("Is 2nd list a palindrome?  " + isPalindrome(list2));
        System.out.println("Is 3nd list a palindrome?  " + isPalindrome(list3));


    }

    private static boolean isPalindrome(DoublyLinkedList<Integer> list) {
        DoublyLinkedList.Node<Integer> start = list.head;
        DoublyLinkedList.Node<Integer> end = list.tail;
        if (list.isEmpty()) {
            return true;
        }
        while (start != end) {
            if (!start.data.equals(end.data)) {
                return false;
            }
            start = start.next;
            end = end.prev;
        }
        return true;
    }
}
