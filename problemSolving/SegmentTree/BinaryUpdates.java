package SegmentTree;

import java.util.ArrayList;
import java.util.Arrays;

public class BinaryUpdates {

    public static void main(String[] args) {
        BinaryUpdates binaryUpdates = new BinaryUpdates();
        int[][] b = new int[3][2];
        b[0][0] = 1;
        b[0][1] = 2;

        b[1][0] = 0;
        b[1][1] = 2;

        b[2][0] = 1;
        b[2][1] = 4;


        //System.out.println(binaryUpdates.solve(4, b));

        b = new int[4][2];
        b[0][0] = 0;
        b[0][1] = 3;

        b[1][0] = 1;
        b[1][1] = 4;

        b[2][0] = 0;
        b[2][1] = 3;

        b[2][0] = 1;
        b[2][1] = 5;


        System.out.println(binaryUpdates.solve(5, b));
    }

    public int[] solve(int n, int[][] B) {

        int[] A = new int[n];
        Arrays.fill(A, 1);
        int no_of_one = n;
        int[] segmentTree = new int[n << 2];
        ArrayList<Integer> res = new ArrayList<Integer>();

        buildSegmentTree(segmentTree, 0, n - 1, 0);

        for (int i = 0; i < B.length; i++) {
            if (B[i][0] == 0) {
                int pos = B[i][1] - 1;
                if (A[pos] == 1) {
                    A[pos] = 0;
                    no_of_one--;
                    updateSegmentTree(segmentTree, 0, n - 1, 0, pos);
                }
            } else {
                int num = B[i][1];
                if (num > no_of_one) {
                    res.add(-1);
                } else {
                    res.add(querySegmentTree(segmentTree, 0, n - 1, 0, num) + 1);
                }
            }
        }

        return res.stream().mapToInt(i -> i).toArray();
    }


    int buildSegmentTree(int[] segmentTree, int start, int end, int index) {
        if (start == end) {
            return segmentTree[index] = 1;
        }

        int mid = start + end >> 1;

        int left = buildSegmentTree(segmentTree, start, mid, (index << 1) + 1);
        int right = buildSegmentTree(segmentTree, mid + 1, end, (index << 1) + 2);

        return segmentTree[index] = left + right;
    }

    int updateSegmentTree(int[] segmentTree, int start, int end, int index, int updated_pos) {
        if (start > updated_pos || end < updated_pos) {
            return segmentTree[index];
        }
        if (start == end) {
            return segmentTree[index] = 0;
        }

        int mid = start + end >> 1;

        int left = updateSegmentTree(segmentTree, start, mid, (index << 1) + 1, updated_pos);
        int right = updateSegmentTree(segmentTree, mid + 1, end, (index << 1) + 2, updated_pos);

        return segmentTree[index] = left + right;
    }

    int querySegmentTree(int[] segmentTree, int start, int end, int index, int num) {
        if (start == end) {
            return start;
        }
        int mid = start + end >> 1;
        int left_index = (index << 1) + 1;
        int right_index = (index << 1) + 2;

        if (num <= segmentTree[left_index]) {
            return querySegmentTree(segmentTree, start, mid, left_index, num);
        } else {
            return querySegmentTree(segmentTree, mid + 1, end, right_index, num - segmentTree[left_index]);
        }
    }
}
