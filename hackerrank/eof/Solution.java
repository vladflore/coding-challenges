import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> lines = new ArrayList<>();
        while (scanner.hasNext()) {
            lines.add(scanner.nextLine());
        }
        for (int i = 0; i < lines.size(); i++) {
            System.out.println((i + 1) + " " + lines.get(i));
        }
        scanner.close();
    }
}