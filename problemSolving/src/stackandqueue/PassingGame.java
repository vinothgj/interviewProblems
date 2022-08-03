package stackandqueue;

import java.util.Stack;

public class PassingGame {
    public int solve(int A, int B, int[] C) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(B);

        for (int i = 0; i < C.length; i++) {
            if (C[i] == 0) {
                if (!stack.isEmpty()) {
                    Integer pop = stack.pop();
                    System.out.println("Pass back from " + pop + " to " + stack.peek());
                } else {
                    System.out.println("Nobody is in possession of the ball");
                }

            } else {
                stack.push(C[i]);
            }
        }

        return stack.peek();

    }

    public static void main(String arg[]) {
        PassingGame passingGame = new PassingGame();
        System.out.println(passingGame.solve(10, 23, new int[]{86, 63, 60, 0, 47, 0, 99, 9, 0, 0}));
        System.out.println(passingGame.solve(1, 1, new int[]{2}));
    }
}
