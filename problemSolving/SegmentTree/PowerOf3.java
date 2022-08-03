package SegmentTree;

import java.util.ArrayList;

public class PowerOf3 {
    public ArrayList<Integer> solve(String A, ArrayList<ArrayList<Integer>> B) {
        SegTree tree = new SegTree(A.length());

        tree.build(A);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < B.size(); i++) {
            ArrayList<Integer> query = B.get(i);
            if (query.get(0) == 0) {
                res.add(tree.query(1, 1, A.length(), query.get(1), query.get(2)));
            } else {
                tree.update(1, 1, A.length(), query.get(1));
                res.add(-1);
            }
        }
        return res;
    }

    public class SegTree {
        int[] arr;

        public SegTree(int N) {
            arr = new int[4 * N];
        }

        public void build(String A) {
            build(A, 1, 1, A.length());
        }

        public int query(int root, int start, int end, int qStart, int qEnd) {
            if (start == qStart && end == qEnd) {
                return arr[root];
            }

            int mid = start + (end - start) / 2;

            if (qEnd <= mid) {
                return query(left(root), start, mid, qStart, qEnd);
            } else if (qStart <= mid && mid <= qEnd) {
                int left = query(left(root), start, mid, qStart, mid);
                int right = query(right(root), mid + 1, end, mid + 1, qEnd);

                if ((qEnd - mid) % 2 == 0) {
                    return (left + right) % 3;
                } else {
                    return (3 - left + right) % 3;
                }
            } else {
                return query(right(root), mid + 1, end, qStart, qEnd);
            }
        }

        public void update(int root, int start, int end, int index) {
            if (start == index && end == index) {
                arr[root] = 1;
                return;
            }

            int mid = start + (end - start) / 2;
            if (index <= mid) {
                update(left(root), start, mid, index);
            } else {
                update(right(root), mid + 1, end, index);
            }

            if ((end - mid) % 2 == 0) {
                arr[root] = (arr[left(root)] + arr[right(root)]) % 3;
            } else {
                arr[root] = (3 - arr[left(root)] + arr[right(root)]) % 3;
            }
        }

        public void build(String A, int root, int start, int end) {
            if (start == end) {
                arr[root] = A.charAt(start - 1) - '0';
                return;
            }

            int mid = start + (end - start) / 2;
            build(A, left(root), start, mid);
            build(A, right(root), mid + 1, end);

            if ((end - mid) % 2 == 0) {
                arr[root] = (arr[left(root)] + arr[right(root)]) % 3;
            } else {
                arr[root] = (3 - arr[left(root)] + arr[right(root)]) % 3;
            }
        }

        public int left(int root) {
            return 2 * root;
        }

        public int right(int root) {
            return 2 * root + 1;
        }
    }
}
