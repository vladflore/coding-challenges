package tech.vladflore.educative.fast_slow_pointers;

public class PalindromicLinkedList {

    public static boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        // find the middle element
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println("Middle element is: " + slow);

        // slow points to the middle element
        // reverse the second half
        ListNode headSecondHalf = reverse(slow);

        System.out.println("After first reverse: " + headSecondHalf);

        ListNode copyHeadSecondHalf = headSecondHalf;

        // go through the halves element by element and check if they differ, if so then
        // it is not a palindrome
        while (head != null && headSecondHalf != null) {
            if (head.value != headSecondHalf.value) {
                break;
            }
            head = head.next;
            headSecondHalf = headSecondHalf.next;
        }

        // reverse the second half again
        reverse(copyHeadSecondHalf);

        if (head == null || headSecondHalf == null) {
            return true;
        }

        return false;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));

        head.next.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));
    }
}
