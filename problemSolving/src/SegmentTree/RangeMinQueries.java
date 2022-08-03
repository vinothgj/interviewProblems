package SegmentTree;

import java.util.ArrayList;

public class RangeMinQueries {
    int[] tree;
    ArrayList<Integer> src;

    int power(int n) {
        int count = 0, temp = n, val = 1;

        while (temp >= 2) {
            temp /= 2;
            count++;
        }

        while (count > 0) {
            val *= 2;
            count--;
        }

        if (val < n) {
            val = val * 2;
        }
        return val;
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        int n = A.size();
        src = A;
        int pow = power(n);

        while (A.size() < pow) {
            A.add(Integer.MAX_VALUE);
        }
        src = A;

        tree = new int[2 * pow - 1];
        ArrayList<Integer> ans = new ArrayList<Integer>();

        buildSegmentTree(0, 0, pow - 1);

        for (int i = 0; i < B.size(); i++) {
            if (B.get(i).get(0) == 1) {
                int val = query(0, 0, pow - 1, B.get(i).get(1) - 1, B.get(i).get(2) - 1);
                ans.add(val);
            } else if (B.get(i).get(0) == 0) {
                update(0, 0, pow - 1, B.get(i).get(1) - 1, B.get(i).get(2));
            }
        }

        return ans;
    }

    void update(int index, int start, int end, int point, int newValue) {
        if (start == end) {
            tree[index] = newValue;
        }

        int mid = (start + end) / 2;
        int indexLeft = 2 * index + 1;
        int indexRight = 2 * index + 2;

        if (indexRight < tree.length) {
            if (point <= mid) {
                update(indexLeft, start, mid, point, newValue);
            } else {
                update(indexRight, mid + 1, end, point, newValue);
            }
            tree[index] = Math.min(tree[indexLeft], tree[indexRight]);
        }
    }

    int query(int idx, int start, int end, int left, int right) {
        if (right < start || left > end) {
            return Integer.MAX_VALUE;
        }
        if (start >= left && right >= end) {
            return tree[idx];
        }

        int mid = (start + end) / 2;
        int leftIndex = 2 * idx + 1;
        int rightIndex = 2 * idx + 2;

        int ansLeft = query(leftIndex, start, mid, left, right);
        int ansRight = query(rightIndex, mid + 1, end, left, right);
        return Math.min(ansLeft, ansRight);
    }

    void buildSegmentTree(int index, int start, int end) {
        if (start == end) {
            tree[index] = src.get(start);
            return;
        }

        int mid = (start + end) / 2;
        int indexLeft = 2 * index + 1;
        int indexRight = (2 * index) + 2;
        buildSegmentTree(indexLeft, start, mid);
        buildSegmentTree(indexRight, mid + 1, end);
        tree[index] = Math.min(tree[indexLeft], tree[indexRight]);
    }

    public static void main(String[] arg) {
        RangeMinQueries rangeMinQueries = new RangeMinQueries();

        ArrayList<Integer> inpA_1 = new ArrayList<Integer>();
        inpA_1.add(1);
        inpA_1.add(4);
        inpA_1.add(1);

        ArrayList<ArrayList<Integer>> inpB_1 = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> inpC_1 = new ArrayList<Integer>();
        inpC_1.add(1);
        inpC_1.add(1);
        inpC_1.add(3);
        inpB_1.add(inpC_1);

        inpC_1 = new ArrayList<Integer>();
        inpC_1.add(0);
        inpC_1.add(1);
        inpC_1.add(5);
        inpB_1.add(inpC_1);

        inpC_1 = new ArrayList<Integer>();
        inpC_1.add(1);
        inpC_1.add(1);
        inpC_1.add(2);
        inpB_1.add(inpC_1);

        System.out.println(rangeMinQueries.solve(inpA_1, inpB_1));

        ArrayList<Integer> inpA_2 = new ArrayList<Integer>();
        inpA_2.add(5);
        inpA_2.add(4);
        inpA_2.add(5);
        inpA_2.add(7);

        ArrayList<ArrayList<Integer>> inpB_2 = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> inpC_2 = new ArrayList<Integer>();
        inpC_2.add(1);
        inpC_2.add(2);
        inpC_2.add(4);
        inpB_2.add(inpC_2);

        inpC_2 = new ArrayList<Integer>();
        inpC_2.add(0);
        inpC_2.add(1);
        inpC_2.add(2);
        inpB_2.add(inpC_2);

        inpC_2 = new ArrayList<Integer>();
        inpC_2.add(1);
        inpC_2.add(1);
        inpC_2.add(4);
        inpB_2.add(inpC_2);

        System.out.println(rangeMinQueries.solve(inpA_2, inpB_2));




        /*System.out.println(rangeMinQueries.power(9));
        System.out.println(rangeMinQueries.power(10));
        System.out.println(rangeMinQueries.power(11));
        System.out.println(rangeMinQueries.power(12));
        System.out.println(rangeMinQueries.power(13));
        System.out.println(rangeMinQueries.power(14));
        System.out.println(rangeMinQueries.power(15));
        System.out.println(rangeMinQueries.power(16));*/

    }
}
