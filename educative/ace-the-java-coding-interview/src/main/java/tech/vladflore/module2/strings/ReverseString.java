package tech.vladflore.module2.strings;

import java.util.ArrayDeque;
import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        String stringToReverse1 = "Hello World!";
        System.out.println("1.    Actual string:   " + stringToReverse1);
        char[] stringChar = stringToReverse1.toCharArray();
        System.out.println("      Reversed string: " + reverseWords(stringChar));
        System.out.println("      Reversed string: " + reverseWords1(stringToReverse1));

        String stringToReverse2 = "The quick brown fox jumped over the lazy dog.";
        System.out.println("2.    Actual string:   " + stringToReverse2);
        stringChar = stringToReverse2.toCharArray();
        System.out.println("      Reversed string: " + reverseWords(stringChar));
        System.out.println("      Reversed string: " + reverseWords1(stringToReverse2));

    }

    private static String reverseWords(char[] stringChar) {
        // reverse the entire sentence
        // reverse each word individually in the new sentence
        // note: keep track of where words begin and end (space separated)
        return null;
    }

    private static String reverseWords1(String sentence) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        Arrays.stream(sentence.split("\\s+")).forEach(stack::push);
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
            result.append(" ");
        }
        return result.substring(0, result.lastIndexOf(" "));
    }
}
