public class CycleDetection {
	public static void main(String args[]) {
		var arr = new Integer[] { 1, 2, 3, 4 };
		var list = new LinkedList<Integer>();
		list.addAll(arr);
		list.print();
		System.out.println("Cyclic? %s".formatted(isCyclic(list.head)));

		list.getNode(list.size - 2).ifPresent(n -> n.next = list.head.next);
		System.out.println("Cyclic? %s".formatted(isCyclic(list.head)));

		if (isCyclic(list.head)) {
			System.out.println("Cyclic list, will not print...");
		} else {
			list.print();
		}

	}

	public static boolean isCyclic(Node<Integer> head) {
		Node<Integer> slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}
}
