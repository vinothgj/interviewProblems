package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeOverlappingIntervals {

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, n = intervals.size();
        boolean reset = false;
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });

        ArrayList<Interval> newIntervals = new ArrayList<Interval>();

        for (int i = 1; i < n; i++) {
            Interval interval1 = intervals.get(i - 1);
            Interval interval2 = intervals.get(i);

            // no overlap
            if (interval1.start > interval2.end || interval2.start > interval1.end) {
                if (min != Integer.MAX_VALUE && max != Integer.MIN_VALUE) {
                    Interval newInterval = new Interval(min, max);
                    newIntervals.add(newInterval);
                    newIntervals.add(interval2);
                    min = Integer.MAX_VALUE;
                    max = Integer.MIN_VALUE;
                    reset = true;
                } else {
                    newIntervals.add(interval1);
                }
            }

            //complete overlap
            else if (interval1.start <= interval2.start && interval1.end >= interval2.end) {
                min = Math.min(min, interval1.start);
                max = Math.max(max, interval1.end);
            } else if (interval2.start <= interval1.start && interval2.end >= interval1.end) {
                min = Math.min(min, interval2.start);
                max = Math.max(max, interval2.end);
            }

            //partial overlap
            else if (interval1.start <= interval2.start && interval1.end <= interval2.end) {
                min = Math.min(min, interval1.start);
                max = Math.max(max, interval2.end);
            } else if (interval1.start >= interval2.start && interval1.end >= interval2.end) {
                min = Math.min(min, interval2.start);
                max = Math.max(max, interval1.end);
            }
        }

        if (!reset) {
            if ((min == Integer.MAX_VALUE && max == Integer.MIN_VALUE)) {
                newIntervals.add(intervals.get(n - 1));
            } else if (min != Integer.MAX_VALUE && max != Integer.MIN_VALUE) {
                newIntervals.add(new Interval(min, max));
            }
        }

        Collections.sort(newIntervals, new IntervalComparator());

        return newIntervals;

    }

    class IntervalComparator implements Comparator<Interval> {

        // override the compare() method
        public int compare(Interval s1, Interval s2) {
            if (s1.start > s2.start && s1.end > s2.end) {
                return 0;
            } else {
                return -1;
            }
        }
    }

    static class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String args[]) {
        MergeOverlappingIntervals mergeOverlappingIntervals = new MergeOverlappingIntervals();
        ArrayList<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(2, 5));
        input.add(new Interval(4, 7));
        input.add(new Interval(6, 10));
        input.add(new Interval(12, 15));
        /*input.add(new Interval(2, 4));
        input.add(new Interval(7, 13));
        input.add(new Interval(12, 15));*/
        System.out.println(mergeOverlappingIntervals.merge(input));
    }
}
