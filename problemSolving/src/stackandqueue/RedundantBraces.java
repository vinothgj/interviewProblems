package stackandqueue;

import java.util.Stack;

public class RedundantBraces {

    public int braces(String A) {
        int n = A.length();
        char[] arr = A.toCharArray();
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < arr.length; i++) {
            char atIndex = arr[i];
            int val = atIndex - 'a';
            if (atIndex == '(' || atIndex == '+' || atIndex == '-' || atIndex == '/' || atIndex == '*') {
                stack.push(atIndex);
            } else {
                if (atIndex == ')') {
                    char peek = stack.peek();
                    if (peek == '+' || peek == '-' || peek == '/' || peek == '*') {
                        stack.pop();
                        stack.pop();
                    } else if (peek == '(') {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String args[]) {
        RedundantBraces redundantBraces = new RedundantBraces();
        System.out.println(redundantBraces.braces("((a+b))"));
        System.out.println(redundantBraces.braces("(a+(a+b))"));
    }

}
