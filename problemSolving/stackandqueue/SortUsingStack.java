package stackandqueue;

import java.util.Stack;

public class SortUsingStack {
    public int[] solve(int[] A) {

        Stack<Integer> sorted = new Stack<Integer>(), temp = new Stack<Integer>();
        int n = A.length, j = n - 1;
        boolean isBreak = false;

        if (sorted.isEmpty()) {
            sorted.push(A[0]);
        }

        for (int i = 1; i < n; i++) {
            int peek = sorted.peek();
            int indexValue = A[i];
            if (indexValue >= peek) {
                sorted.push(indexValue);
            } else {
                while (peek != Integer.MIN_VALUE) {
                    if (peek > indexValue) {
                        sorted.pop();
                        temp.push(peek);
                    } else {
                        sorted.push(indexValue);
                        isBreak = true;
                        break;
                    }
                    if (sorted.isEmpty()) {
                        peek = Integer.MIN_VALUE;
                    } else {
                        peek = sorted.peek();
                    }
                }
                if (!isBreak) {
                    sorted.push(indexValue);
                }
                while (!temp.isEmpty() && temp.peek() != -1) {
                    sorted.push(temp.pop());
                }
                isBreak = false;
            }
        }
        while (!sorted.isEmpty()) {
            A[j] = sorted.pop();
            j--;
        }

        return A;

    }

    public static void main(String arg[]) {
        SortUsingStack sortUsingStack = new SortUsingStack();
        System.out.println(sortUsingStack.solve(new int[]{5, 4, 3, 2, 1}));
        System.out.println(sortUsingStack.solve(new int[]{5, 17, 100, 11}));
        System.out.println(sortUsingStack.solve(new int[]{50, 17, 100, 11, 6, 19, 200, 158, 20, 45, 12, 8}));
        System.out.println(sortUsingStack.solve(new int[]{60, 15, 100, 88, 37, 87, 76, 7}));
    }
}
