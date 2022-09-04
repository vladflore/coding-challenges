package tech.vladflore.module2.stacksandqueues;

import java.util.ArrayDeque;
import java.util.stream.IntStream;

public class ReverseFirstKOfQueue {
    public static void main(String[] args) {
        ArrayDeque<Integer> queue = new ArrayDeque<>(10);
        IntStream.rangeClosed(1, 10).forEach(queue::addLast);
        reverseK(queue, 11);
        while (!queue.isEmpty()) {
            System.out.println(queue.pollFirst());
        }
    }

    private static void reverseK(ArrayDeque<Integer> queue, int k) {
        if (queue.isEmpty() || k <= 1) {
            return;
        }
        k = Math.min(k, queue.size());
        ArrayDeque<Integer> stack = new ArrayDeque<>(k);
        for (int i = 0; i < k; i++) {
            Integer element = queue.poll();
            if (element != null) {
                stack.push(element);
            }
        }
        while (!stack.isEmpty()) {
            queue.addLast(stack.pop());
        }
        for (int i = 0; i < queue.size() - k; i++) {
            queue.addLast(queue.poll());
        }
    }
}
