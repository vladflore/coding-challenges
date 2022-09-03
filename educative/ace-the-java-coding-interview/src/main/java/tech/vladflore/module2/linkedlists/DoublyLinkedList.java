package tech.vladflore.module2.linkedlists;

public class DoublyLinkedList<T> {

    public Node<T> head;
    public Node<T> tail;
    public int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null && tail == null;
    }


    public void insertAtHead(T data) {
        Node<T> newNode = new Node<>();
        newNode.data = data;
        newNode.next = head;
        newNode.prev = null;
        if (head != null) {
            head.prev = newNode;
        } else {
            tail = newNode;
        }
        head = newNode;
        size++;
    }

    public void insertAtEnd(T data) {
        if (isEmpty()) {
            insertAtHead(data);
            return;
        }
        Node<T> newNode = new Node<>();
        newNode.data = data;
        newNode.next = null;
        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public void print() {
        final var sb = new StringBuilder();
        if (isEmpty()) {
            sb.append("List is empty!");
        } else {
            Node<T> temp = head;
            sb.append("List : null <- ");
            while (temp.next != null) {
                sb.append(temp.data.toString()).append(" <-> ");
                temp = temp.next;
            }
            sb.append(temp.data.toString()).append(" -> null");
        }
        System.out.println(sb);
    }

    public void printReverse() {
        final var sb = new StringBuilder();
        if (isEmpty()) {
            sb.append("List is empty!");
        } else {
            Node<T> temp = tail;
            sb.append("List : null <- ");
            while (temp.prev != null) {
                sb.append(temp.data.toString()).append(" <-> ");
                temp = temp.prev;
            }
            sb.append(temp.data.toString()).append(" -> null");
        }
        System.out.println(sb);
    }

    public void deleteAtHead() {
        if (isEmpty()) {
            return;
        }
        head = head.next;
        if (head == null) {
            tail = null;
        } else {
            head.prev = null;
        }
        size--;
    }

    public void deleteAtTail() {
        if (isEmpty()) {
            return;
        }
        tail = tail.prev;
        if (tail == null) {
            head = null;
        } else {
            tail.next = null;
        }
        size--;
    }


    public void deleteByValue(T data) {
        if (isEmpty()) {
            return;
        }
        Node<T> currentNode = this.head;
        if (currentNode.data.equals(data)) {
            deleteAtHead();
            return;
        }
        while (currentNode != null) {
            if (currentNode.data.equals(data)) {
                currentNode.prev.next = currentNode.next;
                if (currentNode.next != null) {
                    currentNode.next.prev = currentNode.prev;
                }
                size--;
                return;
            }
            currentNode = currentNode.next;
        }
    }

    static class Node<E> {

        E data;
        Node<E> next;
        Node<E> prev;

    }
}
