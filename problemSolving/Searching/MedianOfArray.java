package Searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MedianOfArray {
    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        double i = 0.0;
        List<Integer> src = new ArrayList<Integer>();
        src.addAll(a);
        src.addAll(b);

        Collections.sort(src);
        int count = src.size();
        int mid = count / 2;

        if (count % 2 == 0) {
            i = src.get(mid) + src.get(mid - 1);
            i /= 2;
        } else {
            i = src.get(mid);
        }
        return i;
    }

    public static void main(String args[]) {
        MedianOfArray medianOfArray = new MedianOfArray();
        List<Integer> a = new ArrayList<>(Arrays.asList(1, 4, 5));
        List<Integer> b = new ArrayList<>(Arrays.asList(2, 3));
        System.out.println(medianOfArray.findMedianSortedArrays(a, b));
        a = new ArrayList<>(Arrays.asList(1, 2, 3));
        b = new ArrayList<>(Arrays.asList(4));
        System.out.println(medianOfArray.findMedianSortedArrays(a, b));
        a = new ArrayList<>();
        b = new ArrayList<>(Arrays.asList(21));
        System.out.println(medianOfArray.findMedianSortedArrays(a, b));
        a = new ArrayList<>(Arrays.asList(-50, -41, -40, -19, 5, 21, 28));
        b = new ArrayList<>(Arrays.asList(-50, -21, -10));
        System.out.println(medianOfArray.findMedianSortedArrays(a, b));
    }
}
