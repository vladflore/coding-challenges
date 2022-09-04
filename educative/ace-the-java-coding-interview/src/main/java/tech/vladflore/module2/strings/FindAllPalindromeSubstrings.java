package tech.vladflore.module2.strings;

import java.util.ArrayList;
import java.util.List;

public class FindAllPalindromeSubstrings {
    public static void main(String[] args) {
        String[] inputStr = {"aabbbaa", "321230990", "educative"};
        for (int i = 0; i < inputStr.length; i++) {
            List<String> result = findAllPalindromeSubstrings(inputStr[i]);
            System.out.println((i + 1) + ".   Input string: " + inputStr[i]);
            System.out.println("     Palindromes: " + result);
            System.out.println("     Palindromes: " + findAllPalindromeSubstrings1(inputStr[i]));
            System.out.println("     Total palindrome substrings: " + result.size());
        }
    }

    private static List<String> findAllPalindromeSubstrings(String string) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            for (int j = i + 1; j < string.length(); j++) {
                if (isPalindrome(string, i, j)) {
                    result.add(string.substring(i, j + 1));
                }
            }
        }
        return result;
    }

    private static boolean isPalindrome(String string, int start, int end) {
        while (start < end) {
            if (string.charAt(start) != string.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private static List<String> findAllPalindromeSubstrings1(String string) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            findPalindrome(string, i - 1, i + 1, result);
            findPalindrome(string, i, i + 1, result);
        }
        return result;
    }

    private static void findPalindrome(String string, int start, int end, List<String> result) {
        while (start >= 0 && end <= string.length() - 1) {
            if (string.charAt(start) != string.charAt(end)) {
                break;
            }
            result.add(string.substring(start, end + 1));
            start--;
            end++;
        }
    }
}
