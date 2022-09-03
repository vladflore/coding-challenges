package tech.vladflore.module2.linkedlists;

public class ReverseSubSLL {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = reverse(head, 2, 4);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }

    public static ListNode reverse(ListNode head, int p, int q) {
        if (p == q) {
            return head;
        }
        ListNode current = head;
        ListNode prev = null;
        for (int i = 0; i < p - 1; i++) {
            prev = current;
            current = current.next;
        }
        // prev -> p-1
        // current -> p
        ListNode lastNodeFirstPart = prev;
        ListNode lastNodeSubList = current;
        ListNode next;
        for (int i = 0; i < q - p + 1; i++) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        // prev -> q
        // current -> q + 1
        if (lastNodeFirstPart != null) {
            lastNodeFirstPart.next = prev;
        } else {
            head = prev;
        }

        lastNodeSubList.next = current;
        return head;
    }
}

class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}