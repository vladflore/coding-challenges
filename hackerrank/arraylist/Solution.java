import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner((System.in));
        List<List<Integer>> data = new ArrayList<>();
        List<Integer> queries = new ArrayList<>();

        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            List<Integer> lines = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).boxed().skip(1).collect(Collectors.toList());
            data.add(lines);
        }
        int q = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < q; i++) {
            queries.addAll(Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).map(val -> val - 1).boxed().collect(Collectors.toList()));
        }

        for (int i = 0; i < queries.size() - 1; i += 2) {
            Integer lineIndex = queries.get(i);
            Integer positionInLine = queries.get(i + 1);
            if (0 <= positionInLine && positionInLine < data.get(lineIndex).size()) {
                System.out.println(data.get(lineIndex).get(positionInLine));
            } else {
                System.out.println("ERROR!");
            }
        }

        scanner.close();

    }
}
