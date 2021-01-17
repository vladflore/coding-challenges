import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();
        List<Integer> ints = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        int q = scanner.nextInt();
        scanner.nextLine();

        long start = System.currentTimeMillis();

        for (int i = 0; i < q; i++) {
            String command = scanner.nextLine();
            if (command.equals("Insert")) {
                int[] insertParams = Arrays.stream(scanner.nextLine().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                ints.add(insertParams[0], insertParams[1]);
            } else if (command.equals("Delete")) {
                int delIndex = Integer.parseInt(scanner.nextLine().trim());
                ints.remove(delIndex);
            }
        }

        System.out.println((System.currentTimeMillis() - start));

        for (int i = 0; i < ints.size(); i++) {
            System.out.print(ints.get(i));
            if (i < ints.size() - 1) {
                System.out.print(" ");
            }
        }

        scanner.close();
    }
}
