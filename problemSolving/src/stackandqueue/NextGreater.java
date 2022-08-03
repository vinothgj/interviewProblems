package stackandqueue;

import java.util.Stack;

public class NextGreater {
    public int[] nextGreater(int[] A) {
        int n = A.length;
        Stack<Integer> stack = new Stack<Integer>();
        int[] ans = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int atIndex = A[i];
            if (stack.isEmpty()) {
                ans[i] = -1;
            } else if (atIndex < stack.peek()) {
                ans[i] = stack.peek();
            } else {
                int peek = stack.peek();
                while (atIndex >= peek) {
                    stack.pop();
                    peek = !stack.isEmpty() ? stack.peek() : Integer.MAX_VALUE;
                }
                ans[i] = peek == Integer.MAX_VALUE ? -1 : stack.peek();
            }
            stack.push(atIndex);
        }

        /*for (int i = 0; i < n; i++) {
            System.out.println(ans[i]);
        }*/

        return ans;
    }

    public static void main(String arg[]) {
        NextGreater nextGreater = new NextGreater();
        System.out.println(nextGreater.nextGreater(new int[]{4, 5, 2, 10}));
        System.out.println(nextGreater.nextGreater(new int[]{3, 2, 1}));
        System.out.println(nextGreater.nextGreater(new int[]{39, 27, 11, 4, 24, 32, 32, 1}));
    }
}
