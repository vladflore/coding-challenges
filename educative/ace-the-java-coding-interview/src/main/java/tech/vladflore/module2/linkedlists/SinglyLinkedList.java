package tech.vladflore.module2.linkedlists;

public class SinglyLinkedList<T> {

    public Node<T> head;
    public int size;

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insertAtHead(T data) {
        Node<T> newNode = new Node<>();
        newNode.data = data;
        newNode.next = head;
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

        Node<T> last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
        size++;
    }

    public void insertAfter(T data, T previousData) {
        Node<T> newNode = new Node<>();
        newNode.data = data;

        Node<T> currentNode = this.head;
        while (currentNode != null && currentNode.data != previousData) {
            currentNode = currentNode.next;
        }
        if (currentNode != null) {
            newNode.next = currentNode.next;
            currentNode.next = newNode;
            size++;
        }
    }

    public void print() {
        final var sb = new StringBuilder();
        if (isEmpty()) {
            sb.append("List is empty!");
        } else {
            Node<T> temp = head;
            sb.append("List : ");
            while (temp.next != null) {
                sb.append(temp.data.toString()).append(" -> ");
                temp = temp.next;
            }
            sb.append(temp.data.toString()).append(" -> null");
        }
        System.out.println(sb);
    }

    public boolean searchNode(T data) {
        Node<T> currentNode = this.head;
        while (currentNode != null) {
            if (currentNode.data.equals(data)) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    public void deleteAtHead() {
        if (isEmpty()) {
            return;
        }
        head = head.next;
        size--;
    }

    public void deleteByValue(T data) {
        if (isEmpty()) {
            return;
        }
        Node<T> currentNode = this.head;
        Node<T> prevNode = null;
        if (currentNode.data.equals(data)) {
            deleteAtHead();
            return;
        }
        while (currentNode != null) {
            if (currentNode.data.equals(data) && prevNode != null) {
                prevNode.next = currentNode.next;
                size--;
                return;
            }
            prevNode = currentNode;
            currentNode = currentNode.next;
        }
    }

    static class Node<E> {

        E data;
        Node<E> next;
    }
}