package tech.vladflore.module2.stacksandqueues;

import java.util.ArrayDeque;
import java.util.Arrays;

public class GenerateBinaryNumbers {
    public static void main(String[] args) {
        int n = 5;
        String[] output = generateFirstNBinaryNumbers(n);
        Arrays.stream(output).forEach(System.out::println);
    }

    private static String[] generateFirstNBinaryNumbers(int n) {
        ArrayDeque<String> queue = new ArrayDeque<>();
        String[] result = new String[n];
        queue.addLast("1");
        for (int i = 0; i < n; i++) {
            result[i] = queue.pollFirst();
            queue.addLast(result[i] + "0");
            queue.addLast(result[i] + "1");
        }
        return result;
    }
}
