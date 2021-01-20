import java.util.*;

public class Solution_TBD {
    // TODO this does not work, fix it!!!
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();

        int[] occurences = new int[10_000_001];
        int uniqueCount = 0;
        int maxCount = 0;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();

            deque.add(num);
            if (occurences[num] == 0) {
                uniqueCount++;
            }
            occurences[num]++;

            if (deque.size() == m) {
                deque.remove();
                if (occurences[num] == 1) {
                    uniqueCount--;
                }
                occurences[num]--;
            }

            maxCount = Math.max(maxCount, uniqueCount);
        }

        System.out.println(maxCount);
        in.close();
    }
}
