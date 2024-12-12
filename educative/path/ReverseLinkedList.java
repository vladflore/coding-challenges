
public class ReverseLinkedList {

    public static void main(String[] args) {
        var arr = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        var list = new LinkedList<Integer>();
        list.addAll(arr);
        list.print();
        reverse(list);
        list.print();
    }

    private static void reverse(LinkedList<Integer> list) {
        var head = list.head;
        var curr = head;
        Node prev = null;
        Node next = null;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }
        head = prev;
        list.head = head;
    }
}
