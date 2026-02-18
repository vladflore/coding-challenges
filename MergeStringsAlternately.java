
public class MergeStringsAlternately {

    public static void main(String[] args) {
        System.out.println("%s merged with %s: got %s, expected %s".formatted(
                "abc", "pqr", solve("abc", "pqr"), "apbqcr"
        ));
        System.out.println("%s merged with %s: got %s, expected %s".formatted(
                "ab", "pqrs", solve("ab", "pqrs"), "apbqrs"
        ));
        System.out.println("%s merged with %s: got %s, expected %s".formatted(
                "abcd", "pq", solve("abcd", "pq"), "apbqcd"
        ));
    }

    private static String solve(String str1, String str2) {
        var sb = new StringBuilder();
        int idx1 = 0, idx2 = 0;
        while (idx1 < str1.length() && idx2 < str2.length()) {
            sb.append(str1.charAt(idx1));
            sb.append(str2.charAt(idx2));
            idx1++;
            idx2++;
        }
        while (idx1 < str1.length()) {
            sb.append(str1.charAt(idx1));
            idx1++;
        }

        while (idx2 < str2.length()) {
            sb.append(str2.charAt(idx2));
            idx2++;
        }

        return sb.toString();
    }
}
