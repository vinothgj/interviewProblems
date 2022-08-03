package Searching;

public class SquareRootOfInteger {

    long ans = 1;

    public int sqrt(int A) {
        if (A <= 1) {
            return A;
        } else if (A <= 4) {
            return A / 2;
        }
        return ((int) identifySquareRoot(A, 0, A / 2));
    }

    long identifySquareRoot(int A, long start, long end) {

        if (start >= end) {
            if ((ans * ans) < A && (start * start) < A) {
                return Math.max(ans, start);
            }
            return ans;
        }

        long mid = start + (end - start) / 2;

        long sqr = mid * mid;

        if (sqr == A) {
            return mid;
        }

        if (sqr < A) {
            ans = mid;
            return identifySquareRoot(A, mid + 1, end);
        }

        return identifySquareRoot(A, start, mid - 1);

    }

    public static void main(String arg[]) {
        SquareRootOfInteger squareRootOfInteger = new SquareRootOfInteger();
        System.out.println(squareRootOfInteger.sqrt(0));
        System.out.println(squareRootOfInteger.sqrt(1));
        System.out.println(squareRootOfInteger.sqrt(2));
        System.out.println(squareRootOfInteger.sqrt(3));
        System.out.println(squareRootOfInteger.sqrt(4));
        System.out.println(squareRootOfInteger.sqrt(5));
        System.out.println(squareRootOfInteger.sqrt(6));
        /*System.out.println(squareRootOfInteger.sqrt(63));
        System.out.println(squareRootOfInteger.sqrt(81));
        System.out.println(squareRootOfInteger.sqrt(740819855));*/
    }
}
