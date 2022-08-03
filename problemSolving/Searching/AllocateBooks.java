package Searching;

public class AllocateBooks {
    public int books(int[] A, int B) {
        if (B > A.length) {
            return -1;
        }

        long sum = 0;
        int k = 0, max = Integer.MIN_VALUE;
        while (k < A.length) {
            max = Math.max(max, A[k]);
            sum += A[k];
            k++;
        }

        long low = max, high = sum;

        while (low <= high) {
            long mid = (high + low) / 2;
            int stud = 1;
            long localSum = 0;

            for (int i = 0; i < A.length; i++) {
                localSum += A[i];
                if (localSum > mid) {
                    stud++;
                    localSum = A[i];
                }
            }

            if (stud <= B) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return (int) low;
    }

    public static void main(String arg[]) {
        AllocateBooks allocateBooks = new AllocateBooks();
        System.out.println(allocateBooks.books(new int[]{12, 34, 67, 90}, 3));
    }
}
