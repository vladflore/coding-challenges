import java.util.*;

public class Solution {

    public static boolean canWin(int leap, int[] game) {
        return isWinnable(leap, game, 0);
    }

    private static boolean isWinnable(int leap, int[] game, int currentPosition) {
        if (currentPosition < 0 || game[currentPosition] == 1)
            return false;
        if ((currentPosition == game.length - 1) || currentPosition + leap > game.length - 1)
            return true;

        game[currentPosition] = 1;

        return isWinnable(leap, game, currentPosition + 1) || isWinnable(leap, game, currentPosition - 1)
                || isWinnable(leap, game, currentPosition + leap);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println((canWin(leap, game)) ? "YES" : "NO");
        }
        scan.close();
    }
}