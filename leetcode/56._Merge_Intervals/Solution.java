import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {

    public static void main(String[] args) {
        int[][] res = new Solution().merge(new int[][] {
                { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 }
        });
        for (int[] a : res) {
            System.out.println(Arrays.toString(a));
        }
        res = new Solution().merge1(new int[][] {
                { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 }
        });
        for (int[] a : res) {
            System.out.println(Arrays.toString(a));
        }
    }

    public int[][] merge(int[][] intervals) {
        List<Interval> intervalList = Arrays.stream(intervals)
                .map(interval -> new Interval(interval[0], interval[1]))
                .collect(Collectors.toList());

        Collections.sort(intervalList, (i1, i2) -> Integer.compare(i1.start, i2.start));

        List<Interval> merged = new ArrayList<>();

        Interval interval = intervalList.get(0);
        int start = interval.start;
        int end = interval.end;

        for (int i = 1; i < intervalList.size(); i++) {
            interval = intervalList.get(i);
            if (interval.start <= end) {
                end = Math.max(interval.end, end);
            } else {
                merged.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        merged.add(new Interval(start, end));

        Stream<int[]> map = merged.stream().map(i -> new int[] { i.start, i.end });
        return map.toArray(int[][]::new);
    }

    public int[][] merge1(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        int start = intervals[0][0];
        int end = intervals[0][1];

        List<int[]> merged = new ArrayList<>();

        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            if (curr[0] <= end) {
                end = Math.max(curr[1], end);
            } else {
                merged.add(new int[] { start, end });
                start = curr[0];
                end = curr[1];
            }
        }

        merged.add(new int[] { start, end });

        return merged.toArray(int[][]::new);
    }

}

class Interval {
    public int start;
    public int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}