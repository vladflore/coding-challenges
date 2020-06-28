import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] dna = scanner.nextLine().trim().toCharArray();
        int cL = 1;
        int cM = 1;
        for (int i = 0; i < dna.length - 1; i++) {
            if (dna[i] == dna[i + 1]) {
                cL++;
                if (cL > cM) {
                    cM = cL;
                }
            } else {
                cL = 1;
            }

        }
        System.out.println(cM);
        scanner.close();
    }
}