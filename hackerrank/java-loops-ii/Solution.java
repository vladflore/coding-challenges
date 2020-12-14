import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            List<Integer> query = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                query.add(a + b * (int) (Math.pow(2.0, j + 1.0) - 1));
            }
            ans.add(query);
        }
        for (List<Integer> l : ans) {
            for (Integer v : l) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
        in.close();
    }
}