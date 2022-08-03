package Greedy;

import java.util.ArrayList;

public class ShipCompany {
    ArrayList<Integer> minHeap, maxHeap;
    int maxSum, minSum;

    public static void main(String arg[]) {
        ShipCompany shipCompany = new ShipCompany();
        /*System.out.println(shipCompany.solve(4, 3, new int[]{2, 1, 1}));
        System.out.println(shipCompany.solve(4, 3, new int[]{2, 2, 2}));
        System.out.println(shipCompany.solve(10, 5, new int[]{10, 3, 3, 1, 2}));*/

        System.out.println(shipCompany.solve(10, 1, new int[]{10}));

    }

    public int[] solve(int A, int B, int[] C) {
        minHeap = new ArrayList<Integer>();
        minSum = maxSum = 0;
        buildMinHeap(C);
        heapifyMin();
        for (int i = 0; i < A; i++) {
            minSum += popMinHeap(0);
        }
        maxHeap = new ArrayList<Integer>();
        buildMaxHeap(C);
        heapifyMax();
        for (int i = 0; i < A; i++) {
            maxSum += popMaxHeap(0);
        }
        return new int[]{maxSum, minSum};
    }

    void buildMinHeap(int[] src) {
        for (int j = 0; j < src.length; j++) {
            minHeap.add(src[j]);
        }
    }

    void buildMaxHeap(int[] src) {
        for (int j = 0; j < src.length; j++) {
            maxHeap.add(src[j]);
        }
    }

    void heapifyMin() {
        int n = minHeap.size(), lastParent = (n - 1) / 2;
        int leftChild = 0, rightChild = 0, left = 0, right = 0, parent = 0;

        while (lastParent >= 0) {
            leftChild = 2 * lastParent + 1;
            rightChild = 2 * lastParent + 2;

            parent = minHeap.get(lastParent);
            left = leftChild > (n - 1) ? Integer.MAX_VALUE : minHeap.get(leftChild);
            right = rightChild > (n - 1) ? Integer.MAX_VALUE : minHeap.get(rightChild);

            if (parent > left || parent > right) {

                if (left != Integer.MAX_VALUE && left < right) {
                    minHeap.set(lastParent, left);
                    minHeap.set(leftChild, parent);
                } else if (right != Integer.MAX_VALUE) {
                    minHeap.set(lastParent, right);
                    minHeap.set(rightChild, parent);
                }
            }
            lastParent = lastParent - 1;
        }
    }

    void heapifyMax() {
        int n = maxHeap.size(), lastParent = (n - 1) / 2;
        int leftChild = 0, rightChild = 0, left = 0, right = 0, parent = 0;

        while (lastParent >= 0) {
            leftChild = 2 * lastParent + 1;
            rightChild = 2 * lastParent + 2;

            parent = maxHeap.get(lastParent);
            left = leftChild > (n - 1) ? Integer.MIN_VALUE : maxHeap.get(leftChild);
            right = rightChild > (n - 1) ? Integer.MIN_VALUE : maxHeap.get(rightChild);

            if (parent < left || parent < right) {

                if (left != Integer.MIN_VALUE && left > right) {
                    maxHeap.set(lastParent, left);
                    maxHeap.set(leftChild, parent);
                } else if (right != Integer.MIN_VALUE) {
                    maxHeap.set(lastParent, right);
                    maxHeap.set(rightChild, parent);
                }
            }
            lastParent = lastParent - 1;
        }
    }

    public int popMinHeap(int index) {
        if (minHeap.size() == 0) {
            return 0;
        }
        int lastIndex = minHeap.size() - 1, returnVal = minHeap.get(index);
        if (index == lastIndex) {
            if ((returnVal - 1) == 0) {
                minHeap.remove(index);
            } else {
                minHeap.set(index, returnVal - 1);
            }
            return returnVal;
        }
        swap(index, lastIndex, minHeap);
        if (minHeap.get(lastIndex) == 0) {
            minHeap.remove(lastIndex);
        }
        heapifyMin();
        return returnVal;
    }

    public int popMaxHeap(int index) {
        if (maxHeap.size() == 0) {
            return 0;
        }
        int lastIndex = maxHeap.size() - 1, returnVal = maxHeap.get(index);
        if (index == lastIndex) {
            if ((returnVal - 1) == 0) {
                maxHeap.remove(index);
            } else {
                maxHeap.set(index, returnVal - 1);
            }
            return returnVal;
        }
        swap(index, lastIndex, maxHeap);
        heapifyMax();
        return returnVal;
    }

    private void swap(int start, int end, ArrayList<Integer> heap) {
        int startVal = heap.get(start);
        int endVal = heap.get(end);

        heap.set(start, endVal);
        heap.set(end, startVal - 1);
    }
}
