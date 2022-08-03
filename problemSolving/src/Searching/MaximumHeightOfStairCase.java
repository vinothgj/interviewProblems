package Searching;

public class MaximumHeightOfStairCase {

    int height = 0;

    public int solve(int A) {
        height = 0;
        int end = A % 2 == 0 ? (A / 2) : ((A + 1) / 2);
        return maximumHeight(A, 1, end);
    }

    int maximumHeight(int A, int start, int end) {
        if (start >= end) {
            if (summation(start) <= A) {
                height = start;
            }
            return height;
        }

        int mid = (start + end) / 2;
        long sum = summation(mid);

        if (sum > A) {
            return maximumHeight(A, start, mid - 1);
        }
        height = mid;
        return maximumHeight(A, mid + 1, end);


    }

    long summation(long num) {
        return (num * (num + 1) * 1L) / 2;
    }

    public static void main(String arg[]) {
        MaximumHeightOfStairCase maximumHeightOfStairCase = new MaximumHeightOfStairCase();
        System.out.println(maximumHeightOfStairCase.solve(3));
       /* System.out.println(maximumHeightOfStairCase.solve(20));
        System.out.println(maximumHeightOfStairCase.solve(30));
        System.out.println(maximumHeightOfStairCase.solve(100));
        System.out.println(maximumHeightOfStairCase.solve(86));
        System.out.println(maximumHeightOfStairCase.solve(98764));*/
    }
}
