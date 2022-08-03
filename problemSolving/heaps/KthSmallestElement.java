package heaps;

import java.util.ArrayList;

public class KthSmallestElement {
    ArrayList<Integer> heap;
    int ans = 0;

    public static void main(String arg[]) {
        KthSmallestElement kthSmallestElement = new KthSmallestElement();
        ArrayList<ArrayList<Integer>> inp = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> inner = new ArrayList<Integer>();
        inner.add(9);
        inner.add(11);
        inner.add(15);

        inp.add(inner);

        inner = new ArrayList<Integer>();
        inner.add(10);
        inner.add(15);
        inner.add(17);

        inp.add(inner);

        kthSmallestElement.solve(inp, 6);

        inp = new ArrayList<ArrayList<Integer>>();
        inner = new ArrayList<Integer>();
        inner.add(5);
        inner.add(9);
        inner.add(11);

        inp.add(inner);

        inner = new ArrayList<Integer>();
        inner.add(9);
        inner.add(11);
        inner.add(13);

        inp.add(inner);

        inner = new ArrayList<Integer>();
        inner.add(10);
        inner.add(12);
        inner.add(15);

        inp.add(inner);

        inner = new ArrayList<Integer>();
        inner.add(13);
        inner.add(14);
        inner.add(16);

        inp.add(inner);

        inner = new ArrayList<Integer>();
        inner.add(16);
        inner.add(20);
        inner.add(21);

        inp.add(inner);

        kthSmallestElement.solve(inp, 12);
    }

    public int solve(ArrayList<ArrayList<Integer>> A, int B) {
        if (B > (A.size() * A.get(0).size())) {
            return -1;
        } else if (A.size() == 0) {
            return -1;
        }
        heap = new ArrayList<Integer>();
        buildHeap(A);
        heapify();

        for (int i = 0; i < B; i++) {
            ans = pop(0);
        }
        return ans;
    }

    public int solve(int[][] A, int B) {
        int r = A.length;
        int c = A[0].length;
        if (B == 0 || B > r * c) {
            return -1;
        }
        if (B == 1) {
            return A[0][0];
        }
        int start = A[0][0];
        int end = A[r - 1][c - 1];
        while (start < end) {
            int mid = start + (end - start) / 2;
            int count = 0;
            int j = c - 1;
            for (int i = 0; i < r; i++) {
                while (j >= 0 && A[i][j] > mid) {
                    j--;
                }
                count += (j + 1);
            }
            if (count < B) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    void buildHeap(ArrayList<ArrayList<Integer>> src) {
        for (int i = 0; i < src.size(); i++) {
            for (int j = 0; j < src.get(0).size(); j++) {
                heap.add(src.get(i).get(j));
            }
        }
    }

    void heapify() {
        int n = heap.size(), lastParent = (n - 1) / 2;
        int leftChild = 0, rightChild = 0, left = 0, right = 0, parent = 0;

        while (lastParent >= 0) {
            leftChild = 2 * lastParent + 1;
            rightChild = 2 * lastParent + 2;

            parent = heap.get(lastParent);
            left = leftChild > (n - 1) ? Integer.MAX_VALUE : heap.get(leftChild);
            right = rightChild > (n - 1) ? Integer.MAX_VALUE : heap.get(rightChild);

            if (parent > left || parent > right) {

                if (left != Integer.MAX_VALUE && left < right) {
                    heap.set(lastParent, left);
                    heap.set(leftChild, parent);
                } else if (right != Integer.MAX_VALUE) {
                    heap.set(lastParent, right);
                    heap.set(rightChild, parent);
                }
            }
            lastParent = lastParent - 1;
        }
    }

    public int pop(int index) {
        int lastIndex = heap.size() - 1, returnVal = heap.get(index);
        if (index == lastIndex) {
            return returnVal;
        }
        swap(index, lastIndex);
        heap.remove(lastIndex);
        heapify();
        return returnVal;
    }

    private void swap(int start, int end) {
        int startVal = heap.get(start);
        int endVal = heap.get(end);

        heap.set(start, endVal);
        heap.set(end, startVal);
    }
}
