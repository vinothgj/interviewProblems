package stackandqueue;

import java.util.Stack;

public class BalancedParanthesis {
    public int solve(String A) {
        int n = A.length();
        char[] arr = A.toCharArray();

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < n; i++) {
            char atIndex = arr[i];
            if (atIndex == '{' || atIndex == '(' || atIndex == '[') {
                stack.push(atIndex);
            } else if (atIndex == '}') {
                if (stack.isEmpty() || stack.peek() != '{') {
                    return 0;
                } else {
                    stack.pop();
                }
            } else if (atIndex == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return 0;
                } else {
                    stack.pop();
                }

            } else if (atIndex == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return 0;
                } else {
                    stack.pop();
                }
            }
        }

        if (stack.isEmpty()) {
            return 1;
        }
        return 0;

    }
}
