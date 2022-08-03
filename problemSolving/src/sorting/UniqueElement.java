package sorting;

import java.util.Arrays;

public class UniqueElement {

    public int solve(int[] A) {

        Arrays.sort(A);
        int counter = 0;

        for (int i = 1; i < A.length; i++) {
            if (A[i] == A[i - 1]) {
                A[i] = A[i] + 1;
                counter++;
            } else if (A[i] < A[i - 1]) {
                int diff = A[i - 1] - A[i];
                A[i] = A[i] + diff + 1;
                counter = counter + diff + 1;
            }
        }

        return counter;

    }

    public static void main(String arg[]) {
        UniqueElement uniqueElement = new UniqueElement();
        System.out.println(uniqueElement.solve(new int[]{2, 4, 3, 4, 5, 3}));
    }

}
