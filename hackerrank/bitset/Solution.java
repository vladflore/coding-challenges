import java.util.BitSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            int n = scanner.nextInt();
            int m = scanner.nextInt();
            scanner.nextLine();

            BitSet b1 = new BitSet(n);
            BitSet b2 = new BitSet(n);
            int[] ans = new int[2 * m];
            int idx = 0;

            while (m > 0) {
                String[] operation = scanner.nextLine().split("\\s");
                int firstOperand = Integer.parseInt(operation[1]);
                int secondOperand = Integer.parseInt(operation[2]);

                switch (operation[0]) {
                    case "AND":
                        if (firstOperand == 1) {
                            b1.and(b2);
                        } else if (firstOperand == 2) {
                            b2.and(b1);
                        }
                        ans[idx++] = b1.cardinality();
                        ans[idx++] = b2.cardinality();
                        break;
                    case "OR":
                        if (firstOperand == 1) {
                            b1.or(b2);
                        } else if (firstOperand == 2) {
                            b2.or(b1);
                        }
                        ans[idx++] = b1.cardinality();
                        ans[idx++] = b2.cardinality();
                        break;
                    case "XOR":
                        if (firstOperand == 1) {
                            b1.xor(b2);
                        } else if (firstOperand == 2) {
                            b2.xor(b1);
                        }
                        ans[idx++] = b1.cardinality();
                        ans[idx++] = b2.cardinality();
                        break;
                    case "FLIP":
                        if (firstOperand == 1) {
                            b1.flip(secondOperand);
                        } else if (firstOperand == 2) {
                            b2.flip(secondOperand);
                        }
                        ans[idx++] = b1.cardinality();
                        ans[idx++] = b2.cardinality();
                        break;
                    case "SET":
                        if (firstOperand == 1) {
                            b1.set(secondOperand);
                        } else if (firstOperand == 2) {
                            b2.set(secondOperand);
                        }
                        ans[idx++] = b1.cardinality();
                        ans[idx++] = b2.cardinality();
                        break;
                    default:
                        throw new IllegalArgumentException("Operation " + operation[0] + " not supported!");
                }
                m--;
            }

            for (int i = 0; i < ans.length - 1; i += 2) {
                System.out.println(ans[i] + " " + ans[i + 1]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
