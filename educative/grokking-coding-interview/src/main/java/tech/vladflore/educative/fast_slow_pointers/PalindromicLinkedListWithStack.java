package tech.vladflore.educative.fast_slow_pointers;

import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromicLinkedListWithStack {

    private static boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        // we do not know the length of the linked list and we need to identify the middle element
        ListNode slow = head;
        ListNode fast = head;

        Deque<Integer> stack = new ArrayDeque<>();

        while (fast != null && fast.next != null) {
            stack.push(slow.value);
            slow = slow.next;
            fast = fast.next.next;
        }

        // when the linked list has an even number of elements, i.e. fast pointer is
        // null, slow pointer points exactly to the middle
        // element
        // when the linked list has an odd number of elements, i.e. fast pointer is not
        // null, slow pointer needs to be advanced once to point to the middle element
        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (stack.pop() != slow.value) {
                return false;
            }
            slow = slow.next;
        }
        return true;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + PalindromicLinkedListWithStack.isPalindrome(head));

        head.next.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + PalindromicLinkedListWithStack.isPalindrome(head));

        head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + PalindromicLinkedListWithStack.isPalindrome(head));
    }

}
