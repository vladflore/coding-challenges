package tech.vladflore.module2.strings;

import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RemoveDuplicatesFromString {
    public static void main(String[] args) {
        String str = "dabbac";
        System.out.println("1.     Before: " + str);
        char[] charStr = str.toCharArray();
        System.out.println("       After:  " + removeDuplicates1(charStr));
        String str1 = "aabbbccdddeee";
        System.out.println("2.     Before: " + str1);
        charStr = str1.toCharArray();
        System.out.println("       After:  " + removeDuplicates1(charStr));
        String str2 = "abcdef";
        System.out.println("3.     Before: " + str2);
        charStr = str2.toCharArray();
        System.out.println("       After:  " + removeDuplicates1(charStr));

    }

    private static String removeDuplicates(char[] charStr) {
        if (charStr == null || charStr.length == 0) {
            return "";
        }
        HashSet<Character> uniqueChars = new HashSet<>();
        int readIndex = 0;
        int writeIndex = 0;
        while (readIndex < charStr.length) {
            if (!uniqueChars.contains(charStr[readIndex])) {
                uniqueChars.add(charStr[readIndex]);
                charStr[writeIndex++] = charStr[readIndex];
            }
            readIndex++;
        }
        return String.copyValueOf(charStr, 0, writeIndex);
    }

    private static String removeDuplicates1(char[] charStr) {
        return IntStream.range(0, charStr.length)
                .mapToObj(i -> charStr[i])
                .distinct()
                .map(String::valueOf)
                .collect(Collectors.joining());

//        Set<Character> chars = IntStream.range(0, charStr.length)
//                .mapToObj(i -> charStr[i])
//                .collect(Collectors.toSet());
//        return chars.stream()
//                .map(String::valueOf)
//                .collect(Collectors.joining());
    }
}
