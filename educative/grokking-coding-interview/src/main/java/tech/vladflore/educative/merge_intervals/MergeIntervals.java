package tech.vladflore.educative.merge_intervals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {

    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() < 2) {
            return intervals;
        }
        intervals.sort(Comparator.comparingInt(i -> i.start));

        List<Interval> merged = new LinkedList<>();

        Iterator<Interval> intervalsIt = intervals.iterator();
        Interval interval = intervalsIt.next();
        int start = interval.start;
        int end = interval.end;

        while (intervalsIt.hasNext()) {
            interval = intervalsIt.next();
            if (interval.start <= end) {
                end = Math.max(interval.end, end);
            } else {
                merged.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        merged.add(new Interval(start, end));

        return merged;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input)) {
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        }
        System.out.println();

        input = new ArrayList<>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input)) {
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        }
        System.out.println();

        input = new ArrayList<>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input)) {
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        }
        System.out.println();
    }
}

class Interval {

    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}