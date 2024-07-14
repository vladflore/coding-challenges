import java.util.Optional;

public class LinkedList<T> {
    public Node<T> head;
    int size;

    private void insertNodeAtHead(Node<T> node) {
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    public void addAll(T[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            var node = new Node<T>(arr[i]);
            insertNodeAtHead(node);
        }
    }

    public void print() {
        Node<T> temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            temp = temp.next;
            if (temp != null) {
                System.out.print(" -> ");
            } else {
                System.out.println(" -> null");
            }
        }
    }

    @Override
    public String toString() {
        Node<T> temp = head;
        var sb = new StringBuffer();
        while (temp != null) {
            sb.append(temp.data);
            temp = temp.next;
            if (temp != null) {
                sb.append(" -> ");
            } else {
                sb.append(" -> null");
            }
        }
        return sb.toString();
    }

    public Optional<Node<T>> getNode(int nodeIndex) {
        if (nodeIndex < 0 || nodeIndex > size - 1) {
            return Optional.empty();
        }
        Node<T> current = head;
        int idx = -1;
        while (current != null) {
            idx++;
            if (idx == nodeIndex) {
                return Optional.of(current);
            }
            current = current.next;
        }
        return Optional.ofNullable(current);
    }
}