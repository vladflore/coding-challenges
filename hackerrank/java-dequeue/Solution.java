import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();

        Set<Integer> set = new HashSet<>();

        long max = 0;
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.add(num);
            if (deque.size() == m) {
                set.addAll(deque);
                max = Math.max(set.size(), max);
                deque.remove();
                set.clear();
            }
        }
        System.out.println(max);
        in.close();
    }
}