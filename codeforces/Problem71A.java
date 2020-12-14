import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem71A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<String> words = new ArrayList<>();
        while (n-- > 0) {
            words.add(scanner.nextLine());
        }
        words.stream().map(word -> {
            if (word.length() > 10) {
                return Character.toString(word.charAt(0)) + (word.length() - 2)
                        + Character.toString(word.charAt(word.length() - 1));
            } else {
                return word;
            }
        }).forEach(System.out::println);
        scanner.close();
    }
}