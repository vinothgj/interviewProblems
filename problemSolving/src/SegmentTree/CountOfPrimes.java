package SegmentTree;

import java.util.ArrayList;

public class CountOfPrimes {

    int[] tree;

    public static void main(String[] args) {

        ArrayList<Integer> inpA_1 = new ArrayList<Integer>();
        inpA_1.add(1);
        inpA_1.add(3);
        inpA_1.add(121);
        inpA_1.add(20);
        inpA_1.add(17);
        inpA_1.add(26);
        inpA_1.add(29);

        ArrayList<String> inpB_1 = new ArrayList<String>();
        inpB_1.add("A");
        inpB_1.add("C");
        inpB_1.add("A");

        ArrayList<Integer> inpC_1 = new ArrayList<Integer>();
        inpC_1.add(1);
        inpC_1.add(3);
        inpC_1.add(1);

        ArrayList<Integer> inpD_1 = new ArrayList<Integer>();
        inpD_1.add(7);
        inpD_1.add(19);
        inpD_1.add(7);


        CountOfPrimes countOfPrimes = new CountOfPrimes();
        System.out.println(countOfPrimes.solve(inpA_1, inpB_1, inpC_1, inpD_1));

        ArrayList<Integer> inpA_2 = new ArrayList<Integer>();
        inpA_2.add(7);
        inpA_2.add(15);
        inpA_2.add(11);

        ArrayList<String> inpB_2 = new ArrayList<String>();
        inpB_2.add("C");
        inpB_2.add("A");

        ArrayList<Integer> inpC_2 = new ArrayList<Integer>();
        inpC_2.add(2);
        inpC_2.add(2);

        ArrayList<Integer> inpD_2 = new ArrayList<Integer>();
        inpD_2.add(9);
        inpD_2.add(3);

        //System.out.println(countOfPrimes.solve(inpA_2, inpB_2, inpC_2, inpD_2));
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<String> B, ArrayList<Integer> C, ArrayList<Integer> D) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int n = A.size();
        int pow = power(n);
        while (A.size() < pow) {
            A.add(0);
        }
        tree = new int[2 * pow - 1];

        buildSegmentTree(0, pow - 1, 0, A);

        for (int i = 0; i < B.size(); i++) {
            if (B.get(i) == "A") {
                int countPrime = query(0, 0, n - 1, C.get(i) - 1, D.get(i) - 1);
                ans.add(countPrime);
            } else if (B.get(i) == "C") {
                update(0, 0, n - 1, C.get(i) - 1, D.get(i));
            }
        }
        return ans;
    }

    void buildSegmentTree(int start, int end, int id, ArrayList<Integer> src) {
        if (start == end) {
            tree[id] = src.get(start);
            return;
        }
        int mid = (start + end) / 2;
        int leftIndex = 2 * id + 1;
        int rightIndex = 2 * id + 2;

        buildSegmentTree(start, mid, leftIndex, src);
        buildSegmentTree(mid + 1, end, rightIndex, src);
        if (rightIndex >= (src.size() / 4)) {
            tree[id] = isPrime(leftIndex, tree) + isPrime(rightIndex, tree);
        }
        else {
            tree[id] = tree[leftIndex] + tree[rightIndex];
        }
    }


    int query(int idx, int start, int end, int left, int right) {
        if (right < start || end < left) {
            return 0;
        }
        if (start >= left && right >= end) {
            if (idx >= tree.length / 4) {
                tree[idx] = isPrime(left, tree) + isPrime(right, tree);
            } else {
                tree[idx] = tree[left] + tree[right];
            }
            return tree[idx];
        }

        int mid = (start + end) / 2;
        int leftIndex = 2 * idx + 1;
        int rightIndex = 2 * idx + 2;

        int ansLeft = query(leftIndex, start, mid, left, right);
        int ansRight = query(rightIndex, mid + 1, end, left, right);
        return ansLeft + ansRight;
    }

    void update(int index, int start, int end, int point, int newValue) {
        if (start == end) {
            tree[index] = newValue;
        }

        int mid = (start + end) / 2;
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;

        if (leftIndex < tree.length) {
            if (point <= mid) {
                update(leftIndex, start, mid, point, newValue);
            } else {
                update(rightIndex, mid + 1, end, point, newValue);
            }
            if (index >= tree.length / 4) {
                tree[index] = isPrime(leftIndex, tree) + isPrime(rightIndex, tree);
            } else {
                tree[index] = tree[leftIndex] + tree[rightIndex];
            }
        }
    }

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

    int isPrime(int idx, int[] tree) {
        int val = tree[idx];
        if (val < 2) {
            return 0;
        }
        for (int i = 2; i <= Math.sqrt(val); i++) {
            if (val % i == 0) {
                return 0;
            }
        }
        return 1;
    }
}
