package stackandqueue;

import java.util.Stack;

public class TwoBracketExpression {
    public int solve(String A, String B) {

        char[] arr = A.toCharArray();
        int n = arr.length;
        String ans = "";

        Stack<Character> stack = new Stack<Character>();
        boolean bracketEncountered = false;
        char operator = '#';

        int i = 0;
        while (i < n) {
            char atIndex = arr[i];
            if (atIndex > 96 && atIndex < 123) {
                ans += atIndex;
            } else if (atIndex == '(') {
                if (!stack.isEmpty()) {
                    operator = stack.pop();
                }
                stack.push(atIndex);
                if (operator != '#') {
                    stack.push(operator);
                }
                bracketEncountered = true;
            } else if (atIndex == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                bracketEncountered = false;
            } else if ((atIndex == '-' || atIndex == '+') &&
                    (!stack.isEmpty() && (stack.peek() == '-' || stack.peek() == '+'))) {
                operator = '+';
                if (!stack.isEmpty() && bracketEncountered) {
                    if (atIndex != stack.peek()) {
                        operator = '-';
                    } else {
                        operator = '+';
                    }
                } else {
                    operator = atIndex;
                }
                ans += operator;
            } else {
                ans += atIndex;
            }
            i++;
        }

        if (B.startsWith("(") && B.endsWith(")")) {
            ans = "(" + ans + ")";
        }
        return B.equals(ans) ? 1 : 0;
    }


    public static void main(String args[]) {
        TwoBracketExpression twoBracketExpression = new TwoBracketExpression();
        //System.out.println(twoBracketExpression.solve("-(a+b+c)", "-a-b-c"));
        //System.out.println(twoBracketExpression.solve("a-b-(c-d)", "a-b-c-d"));
        System.out.println(twoBracketExpression.solve("(a+b-c-d+e-f+g+h+i)", "a+b-c-d+e-f+g+h+i"));
    }
}
