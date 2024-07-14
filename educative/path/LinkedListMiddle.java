public class LinkedListMiddle {
    public static void main(String[] args) {

        Integer[] arr = new Integer[] { 1, 2, 3, 4 };
        var list = new LinkedList<Integer>();
        list.addAll(arr);
        list.print();
        int element = findMiddle(list.head);
        System.out.println("Middle element of list '%s' is %s".formatted(list, element));

    }

    private static Integer findMiddle(Node<Integer> head) {
        // the case when the list has an even number of elements is not handled!
        Node<Integer> slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }
}
