package stackandqueue;

import java.util.Stack;

public class MaximumXoRElement {
    public int solve(int[] A) {

        int ans = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < A.length; i++) {
            while (!stack.isEmpty()) {
                ans = Math.max(ans, (A[stack.peek()] ^ A[i]));
                if (A[stack.peek()] > A[i]) {
                    break;
                }
                stack.pop();
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String arg[]) {
        MaximumXoRElement maximumXoRElement = new MaximumXoRElement();
        System.out.println(maximumXoRElement.solve(new int[]{2, 3, 1, 4}));
        System.out.println(maximumXoRElement.solve(new int[]{1, 3}));
        System.out.println(maximumXoRElement.solve(new int[]{2, 3, 4, 1, 2}));
    }
}
