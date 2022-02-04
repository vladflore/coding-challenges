package grokking_coding_interview.fast_slow_pointers;

public class LinkedListCycleStart {

    public static ListNode findCycleStart(ListNode head) {
        ListNode fast = head, slow = head;
        int cycleLength = 0;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                cycleLength = calculateCycleLength(fast);
                break;
            }
        }
        return findCycleStart(head, cycleLength);
    }

    private static int calculateCycleLength(ListNode node) {
        ListNode current = node;
        int length = 0;
        do {
            current = current.next;
            length++;
        } while (current != node);
        return length;
    }

    private static ListNode findCycleStart(ListNode head, int cycleLength) {
        ListNode p1 = head, p2 = head;
        while (cycleLength > 0) {
            p2 = p2.next;
            cycleLength--;
        }
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

        head.next.next.next.next.next.next = head;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);
    }
}
