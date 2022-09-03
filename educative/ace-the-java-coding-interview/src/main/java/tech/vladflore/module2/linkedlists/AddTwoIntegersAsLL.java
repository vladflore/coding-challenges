package tech.vladflore.module2.linkedlists;

import java.util.Arrays;
import java.util.List;

public class AddTwoIntegersAsLL {

    public static void main(String[] args) {
        SinglyLinkedList<Integer> obj1 = new SinglyLinkedList<>();
        List<Integer> l1 = Arrays.asList(1, 0, 9, 9);
        for (Integer number : l1) {
            obj1.insertAtHead(number);
        }

        SinglyLinkedList<Integer> obj2 = new SinglyLinkedList<>();
        List<Integer> l2 = Arrays.asList(7, 3, 2);
        for (Integer number : l2) {
            obj2.insertAtHead(number);
        }

        System.out.print("1. First list :      ");
        obj1.print();
        System.out.print("   Second list :     ");
        obj2.print();

        SinglyLinkedList<Integer> res = new SinglyLinkedList<>();
        res.head = addIntegers(obj1.head, obj2.head);
        System.out.print("   Addition result:  ");
        res.print();

        SinglyLinkedList<Integer> obj3 = new SinglyLinkedList<>();
        List<Integer> l3 = Arrays.asList(2, 5, 0, 0, 0);
        for (Integer number : l3) {
            obj3.insertAtHead(number);
        }

        SinglyLinkedList<Integer> obj4 = new SinglyLinkedList<>();
        List<Integer> l4 = Arrays.asList(1, 1, 1, 1);
        for (Integer number : l4) {
            obj4.insertAtHead(number);
        }

        System.out.print("2. First list :      ");
        obj3.print();
        System.out.print("   Second list :     ");
        obj4.print();

        SinglyLinkedList<Integer> res2 = new SinglyLinkedList<>();
        res2.head = addIntegers(obj3.head, obj4.head);
        System.out.print("   Addition result:  ");
        res2.print();
    }

    private static SinglyLinkedList.Node<Integer> addIntegers(SinglyLinkedList.Node<Integer> integer1, SinglyLinkedList.Node<Integer> integer2) {
        SinglyLinkedList<Integer> result = new SinglyLinkedList<>();
        int carry = 0;
        while (integer1 != null || integer2 != null || carry > 0) {
            int addend1 = integer1 != null ? integer1.data : 0;
            int addend2 = integer2 != null ? integer2.data : 0;
            int sum = addend1 + addend2 + carry;
            result.insertAtEnd(sum % 10);
            carry = sum / 10;
            if (integer1 != null) {
                integer1 = integer1.next;
            }
            if (integer2 != null) {
                integer2 = integer2.next;
            }
        }
        return result.head;
    }
}