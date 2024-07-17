import java.util.ArrayDeque;
import java.util.Deque;

public class Queue {

	private Deque<Integer> stack1;
	private Deque<Integer> stack2;

	public Queue() {
		this.stack1 = new ArrayDeque<>();
		this.stack2 = new ArrayDeque<>();
	}

	public void push(int element) {
		// move elements from stack1 to stack2
		while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		// push element into stack1
		stack1.push(element);
		// move elements from stack2 to stack1
		while (!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
	}

	public int pop() {
		return stack1.pop();
	}

	public int peek() {
		return stack1.peek();
	}

	public boolean isEmpty() {
		return stack1.isEmpty();
	}

	public static void main(String[] args) {

		var q = new Queue();
		q.push(1);
		q.push(2);
		q.push(3);
		System.out.format("isEmpty()=%s\n", q.isEmpty());
		System.out.format("pop()=%d\n", q.pop());
		System.out.format("peek()=%d\n", q.peek());
		System.out.format("pop()=%d\n", q.pop());
		System.out.format("pop()=%d\n", q.pop());
		System.out.format("isEmpty()=%s\n", q.isEmpty());
	}
}
