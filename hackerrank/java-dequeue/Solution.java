import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Deque<Integer> deque = new ArrayDeque<>();
		int n = in.nextInt();
		int m = in.nextInt();

		Map<Integer, Integer> map = new HashMap<>();
		int currentDistinctCount = 0;
		int maxDistinctCount = 0;
		for (int i = 0; i < n; i++) {
			int curr = in.nextInt();
			deque.add(curr);
			if (map.get(curr) == null) {
				map.put(curr, 1);
				currentDistinctCount++;
			}
			else {
				map.put(curr, map.get(curr) + 1);
			}
			if (deque.size() == m) {
				maxDistinctCount = Math.max(maxDistinctCount, currentDistinctCount);
				Integer head = deque.remove();
				Integer prev = map.get(head);
				if (prev == 1) {
					currentDistinctCount--;
				}
				else {
					map.put(head, prev - 1);
				}
			}
		}
		System.out.println(maxDistinctCount);
		in.close();
	}
}
