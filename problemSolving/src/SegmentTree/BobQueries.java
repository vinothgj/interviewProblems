package SegmentTree;

import java.util.ArrayList;
import java.util.List;

public class BobQueries {

    public int[] solve(int A, int[][] B) {
        SegmentTree segmentTree = new SegmentTree(A);
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < B.length; i++) {
            if (B[i][0] == 1) {
                segmentTree.update(B[i][1] - 1, val -> 2 * val + 1);
            } else if (B[i][0] == 2) {
                segmentTree.update(B[i][1] - 1, val -> val / 2);
            } else {
                list.add(segmentTree.rangeQuery(B[i][1] - 1, B[i][2] - 1));
            }
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }


    class SegmentTree {
        SegmentInfo[] tree;
        int n = 0;

        SegmentTree(int input) {
            this.n = input;
            tree = new SegmentInfo[4 * n];
            this.buildTree(0, n - 1, 0);
        }

        private void buildTree(int rStart, int rEnd, int pos) {
            for (int i = 0; i < tree.length; i++) {
                tree[i] = new SegmentInfo(0, 0);
            }
        }

        public void update(int index, java.util.function.Function<Integer, Integer> function) {
            update(0, n - 1, index, 0, function);
        }

        private void update(int rStart, int rEnd, int index, int pos, java.util.function.Function<Integer, Integer> function) {
            if (rStart > rEnd) {
                return;
            }
            if (rStart == rEnd && rStart == index) {

                SegmentInfo segmentInfo = tree[pos];
                segmentInfo.val = function.apply(segmentInfo.val);
                segmentInfo.oneCounter = bitFunction(segmentInfo.val);
                return;
            }
            int mid = (rStart + rEnd) / 2;
            if (index <= mid) {
                update(rStart, mid, index, left(pos), function);
            } else {
                update(mid + 1, rEnd, index, right(pos), function);
            }
            if (tree[pos] == null) {
                tree[pos] = new SegmentInfo(0, 0);
            }
            if (tree[left(pos)] == null) {
                tree[left(pos)] = new SegmentInfo(0, 0);
            }
            if (tree[right(pos)] == null) {
                tree[right(pos)] = new SegmentInfo(0, 0);
            }
            tree[pos].oneCounter = operator(tree[left(pos)].oneCounter, tree[right(pos)].oneCounter);
        }

        public int rangeQuery(int qStart, int qEnd) {
            return rangeQuery(0, n - 1, qStart, qEnd, 0);
        }

        public int rangeQuery(int rStart, int rEnd, int qStart, int qEnd, int pos) {
            if (rStart > rEnd) {
                return 0;
            }
            if (qStart <= rStart && rStart <= rEnd && qEnd >= rEnd) {
                return tree[pos].oneCounter;
            }
            if (qEnd < rStart || qStart > rEnd) {
                return 0;
            }
            int mid = (rStart + rEnd) / 2;
            int leftCountOf1 = rangeQuery(rStart, mid, qStart, qEnd, left(pos));
            int rightCountOf1 = rangeQuery(mid + 1, rEnd, qStart, qEnd, right(pos));
            return operator(leftCountOf1, rightCountOf1);
        }

        private int operator(int valL, int valR) {
            return valL + valR;
        }

        private int bitFunction(int val) {
            int count = 0;
            for (int i = 0; i < 32; i++) {
                if ((val & (1 << i)) != 0) {
                    count++;
                }
            }
            return count;
        }

        private int left(int i) {
            return 2 * i + 1;
        }

        private int right(int i) {
            return 2 * i + 2;
        }

        class SegmentInfo {
            int val, oneCounter;

            SegmentInfo(int val, int oneCounter) {
                this.val = val;
                this.oneCounter = oneCounter;
            }

            public String toString() {
                return " val " + val + " countOf1 " + oneCounter;
            }
        }
    }
}
