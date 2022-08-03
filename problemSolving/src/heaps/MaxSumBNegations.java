package heaps;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxSumBNegations {

    public int solve(ArrayList<Integer> A, int B) {
        MinHeap minHeap = new MinHeap(A);
        minHeap.constructHeap();
        int i = 0;
        while (i < B) {
            int min = minHeap.findMin();
            min = (-1) * min;
            minHeap.delete(0);
            minHeap.insert(min);
            i++;
        }

        int sum = 0;
        for (int j = 0; j < A.size(); j++) {
            sum += A.get(j);
        }
        return sum;
    }

    static class MinHeap {
        ArrayList<Integer> list = new ArrayList<>();

        MinHeap(ArrayList<Integer> list) {
            this.list = list;
        }

        public void constructHeap() {
            for (int i = list.size() - 1; i >= 0; i--) {
                sink(i);
            }
        }

        private void sink(int index) {
            int i = index;

            while ((leftChild(i) < list.size() && list.get(i) > list.get(leftChild(i))) ||
                    (rightChild(i) < list.size() && list.get(i) > list.get(rightChild(i)))) {
                int smaller = leftChild(i);
                if (rightChild(i) < list.size() && list.get(rightChild(i)) < list.get(smaller)) {
                    smaller = rightChild(i);
                }
                swap(i, smaller);
                i = smaller;
            }
        }

        private void balance(int index) {
            int i = index;
            while (parent(i) >= 0 && list.get(parent(i)) > list.get(i)) {
                swap(parent(i), i);
                i = parent(i);
            }
        }

        public int findMin() {
            return list.get(0);
        }

        public void delete(int index) {
            int i = index;
            int lastIndex = list.size() - 1;
            swap(i, lastIndex);
            list.remove(lastIndex);
            sink(0);
        }

        public void insert(int val) {
            list.add(val);
            balance(list.size() - 1);
        }

        private int parent(int index) {
            return (index - 1) / 2;
        }

        private int leftChild(int index) {
            return 2 * index + 1;
        }

        private int rightChild(int index) {
            return 2 * index + 2;
        }

        private void swap(int index1, int index2) {
            int temp = this.list.get(index1);
            this.list.set(index1, this.list.get(index2));
            this.list.set(index2, temp);
        }

        void heapify(ArrayList<Integer> inp, int n, int index) {
            while ((index << 1) <= n) {
                int left = (index << 1);
                int right = (index << 1) + 1;

                if (right <= n) {
                    if (inp.get(left - 1) < inp.get(index - 1) && inp.get(left - 1) < inp.get(right - 1)) {
                        swap(inp, index - 1, left - 1);
                        index = left;
                    } else if (inp.get(right - 1) < inp.get(index - 1)) {
                        swap(inp, index - 1, right - 1);
                        index = right;
                    } else {
                        break;
                    }
                } else {
                    if (inp.get(left - 1) < inp.get(index - 1)) {
                        swap(inp, index - 1, left - 1);
                    } else {
                        break;
                    }
                }
            }

        }

        void swap(ArrayList<Integer> A, int index1, int index2) {
            A.set(index1, A.get(index1) ^ A.get(index2));
            A.set(index2, A.get(index1) ^ A.get(index2));
            A.set(index1, A.get(index1) ^ A.get(index2));
        }
    }

    public static void main(String arg[]) {
        MaxSumBNegations maxSumBNegations = new MaxSumBNegations();
        ArrayList<Integer> inp = new ArrayList<Integer>();
        //inp.addAll(Arrays.asList(24, -68, -29, -9, 84));
        inp.addAll(Arrays.asList(57, 3, -14, -87, 42, 38, 31, -7, -28, -61));
        //System.out.println(maxSumBNegations.solve(inp, 4));
        MinHeap minHeap = new MinHeap(inp);
        int n = inp.size();

        for (int i = (n >> 1); i > 0; i--) {
            minHeap.heapify(inp, inp.size(), i);
        }
        System.out.println(inp);
    }
}