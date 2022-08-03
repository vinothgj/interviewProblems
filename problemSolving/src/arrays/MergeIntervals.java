package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeIntervals {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        ArrayList<Interval> newIntervals = new ArrayList<Interval>();
        boolean reset = false;

        for (Interval interval : intervals) {

            // no overlap
            if (interval.start > newInterval.end || newInterval.start > interval.end) {
                if (min != Integer.MAX_VALUE && max != Integer.MIN_VALUE) {
                    Interval interval1 = new Interval(min, max);
                    newIntervals.add(interval1);
                    newIntervals.add(interval);
                    min = Integer.MAX_VALUE;
                    max = Integer.MIN_VALUE;
                    reset = true;
                } else {
                    newIntervals.add(interval);
                }
            }

            //complete overlap
            else if (interval.start <= newInterval.start && interval.end >= newInterval.end) {
                min = Math.min(min, interval.start);
                max = Math.max(max, interval.end);
            } else if (newInterval.start <= interval.start && newInterval.end >= interval.end) {
                min = Math.min(min, newInterval.start);
                max = Math.max(max, newInterval.end);
            }

            //partial overlap
            else if (interval.start <= newInterval.start && interval.end <= newInterval.end) {
                min = Math.min(min, interval.start);
                max = Math.max(max, newInterval.end);
            } else if (interval.start >= newInterval.start && interval.end >= newInterval.end) {
                min = Math.min(min, newInterval.start);
                max = Math.max(max, interval.end);
            }
        }
        /*if ((min == Integer.MAX_VALUE && max == Integer.MIN_VALUE) && !reset) {
            newIntervals.add(newInterval);
        }*/
        if (!reset) {
            if ((min == Integer.MAX_VALUE && max == Integer.MIN_VALUE)) {
                newIntervals.add(newInterval);
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
        MergeIntervals mergeIntervals = new MergeIntervals();
        ArrayList<Interval> input = new ArrayList<Interval>();
       /* input.add(new Interval(2, 5));
        input.add(new Interval(4, 7));
        input.add(new Interval(9, 10));
        input.add(new Interval(12, 15));
        input.add(new Interval(2, 4));
        input.add(new Interval(7, 9));
        input.add(new Interval(12, 15)); */
        input.add(new Interval(3, 5));
        input.add(new Interval(8, 10));
        Interval interval1 = new Interval(1, 12);
        System.out.println(mergeIntervals.insert(input, interval1));
    }
}
