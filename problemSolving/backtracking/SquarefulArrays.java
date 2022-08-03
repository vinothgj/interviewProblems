package backtracking;

import java.util.Arrays;

public class SquarefulArrays {
    int count = 0, n = 0;

    public int solve(int[] A) {
        count = 0;
        n = A.length;
        Arrays.sort(A);
        recursion(A, 0);
        return count;
    }

    void recursion(int[] A, int index) {
        if (index == (n - 1)) {
            int q = 0;
            while (q < n) {
                System.out.print(A[q] + " ");
                q++;
            }
            System.out.println();


            int p = 1;
            while (p < n) {
                if (!isSquare(A[p - 1], A[p])) {
                    break;
                }
                p++;
            }
            if (p == n) {
                count++;
            }
            return;
        }

        for (int k = index; k < n; ++k) {
            if (index != k && A[index] == A[k]) {
                continue;
            } else {
                swap(A, index, k);
                recursion(A, index + 1);
                swap(A, index, k);
            }

        }
    }


    boolean isSquare(int a, int b) {
        int x = a + b;
        int sqr = (int) Math.floor(Math.sqrt(x));
        if ((sqr * sqr) == x) {
            return true;
        }
        return false;
    }

    void swap(int[] A, int index, int k) {
        int temp = A[index];
        A[index] = A[k];
        A[k] = temp;
    }

    public static void main(String arg[]) {
        SquarefulArrays squarefulArrays = new SquarefulArrays();
        /*System.out.println(squarefulArrays.isSquare(10, 9));
        System.out.println(squarefulArrays.isSquare(17, 8));*/
       /* System.out.println(squarefulArrays.solve(new int[]{2, 2, 2}));
        System.out.println(squarefulArrays.solve(new int[]{1, 1, 8}));
        System.out.println(squarefulArrays.solve(new int[]{1, 17, 8}));
        System.out.println(squarefulArrays.solve(new int[]{141, 115, 29, 35}));*/
        System.out.println(squarefulArrays.solve(new int[]{36229, 1020, 69, 127, 162, 127}));
    }


}
