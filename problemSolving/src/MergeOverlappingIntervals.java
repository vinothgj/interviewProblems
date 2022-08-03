// A Java program for merging overlapping intervals

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

public class MergeOverlappingIntervals {

    // The main function that takes a set of intervals, merges
    // overlapping intervals and prints the result
    public static ArrayList<Interval> mergeIntervals(ArrayList<Interval> arr) {
        Stack<Interval> stack = new Stack<>();
        Collections.sort(arr, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });

        int index = 0; // Stores index of last element
        // in output array (modified arr[])

        // Traverse all input Intervals
        for (int i = 1; i < arr.size(); i++) {
            // If this is not first Interval and overlaps
            // with the previous one
            if (arr.get(index).end >= arr.get(index).start) {
                // Merge previous and current Intervals
                arr.get(index).end = Math.max(arr.get(index).end, arr.get(i).end);
                arr.get(index).start = Math.min(arr.get(index).start, arr.get(i).start);
            } else {
                index++;
                arr.set(index, arr.get(i));
            }
        }

        /*while (!stack.isEmpty()) {
            Interval t = stack.pop();
            arr.add(t);
        }*/

        ArrayList<Interval> res = new ArrayList<>();
        for(int i = 0; i <= index; i++) {
            /*System.out.print("Start : " + arr.get(i).start);
            System.out.print("End : " + arr.get(i).end);*/
            res.add(arr.get(i));
        }

        return res;
    }

    public static void main(String args[]) {
        ArrayList<Interval> arr = new ArrayList<Interval>();
       /* arr.add(new Interval(6, 8));
        arr.add(new Interval(1, 9));
        arr.add(new Interval(2, 4));
        arr.add(new Interval(4, 7));*/
        arr.add(new Interval(4, 4));
        arr.add(new Interval(5, 100));
        mergeIntervals(arr);
    }
}

class Interval {
    int start, end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
// This code is contributed by Gaurav Tiwari
