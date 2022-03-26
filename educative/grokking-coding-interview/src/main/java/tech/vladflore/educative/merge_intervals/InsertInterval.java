package tech.vladflore.educative.merge_intervals;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || intervals.isEmpty()) {
            return List.of(newInterval);
        }

        List<Interval> merged = new ArrayList<>();

        // find the location to insert the new interval
        int i = 0;
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            merged.add(intervals.get(i++));
        }

        // at this point we have: newInterval.start <= intervals.get(i).end
        // we also need: newInterval.end > intervals.get(i).start
        // this means that the intervals overlap

        while (i < intervals.size() && newInterval.end > intervals.get(i).start) {
            // change the start and end of the newInterval
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            i++;
        }

        merged.add(newInterval);

        // add the rest of the intervals
        while (i < intervals.size()) {
            merged.add(intervals.get(i++));
        }

        return merged;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert(input, new Interval(4, 6)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert(input, new Interval(4, 10)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(2, 3));
        input.add(new Interval(5, 7));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert(input, new Interval(1, 4)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }

}
