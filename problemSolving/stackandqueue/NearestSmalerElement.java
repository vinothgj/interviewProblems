package stackandqueue;

import java.util.Stack;

public class NearestSmalerElement {

    public int[] prevSmaller(int[] A) {

        int n = A.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < n; i++) {
            int atIndex = A[i];
            if (stack.isEmpty()) {
                ans[i] = -1;
            } else if (atIndex > stack.peek()) {
                ans[i] = stack.peek();
            } else {
                int peek = stack.peek();
                while (atIndex <= peek) {
                    stack.pop();
                    peek = !stack.isEmpty() ? stack.peek() : Integer.MIN_VALUE;
                }
                ans[i] = peek == Integer.MIN_VALUE ? -1 : stack.peek();
            }
            stack.push(atIndex);
        }
        return ans;
    }

    public static void main(String arg[]) {
        NearestSmalerElement nearestSmalerElement = new NearestSmalerElement();
        /*System.out.println(nearestSmalerElement.prevSmaller(new int[]{4, 5, 2, 10, 8}));
        System.out.println(nearestSmalerElement.prevSmaller(new int[]{3, 2, 1}));*/
        System.out.println(nearestSmalerElement.prevSmaller(new int[]{39, 27, 11, 4, 24, 32, 32, 1}));
    }
}
