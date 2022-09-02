package tech.vladflore.module2.linkedlists;

class DetectLoopInSLL {

    public static <T> boolean detectLoop(SinglyLinkedList<T> list) {
        SinglyLinkedList.Node<T> slow = list.head;
        SinglyLinkedList.Node<T> fast = list.head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.insertAtHead(1);
        list.insertAtHead(2);
        list.insertAtHead(3);
        list.print();
        System.out.println("Before adding loop: " + detectLoop(list));
        list.head.next.next = list.head;
        System.out.println("After adding loop: " + detectLoop(list));
    }
}