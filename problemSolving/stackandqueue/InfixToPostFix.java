package stackandqueue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class InfixToPostFix {
    public String solve(String A) {

        char[] arr = A.toCharArray();
        int n = arr.length;

        String ans = "";
        Map<Character, Integer> priorityMap = new HashMap<Character, Integer>();
        boolean bracketEncountered = false;
        Stack<Character> stack = new Stack<Character>();
        priorityMap.put('^', 1);
        priorityMap.put('/', 2);
        priorityMap.put('*', 2);
        priorityMap.put('+', 3);
        priorityMap.put('-', 3);

        int i = 0;
        while (i < n) {
            char atIndex = arr[i];
            if (atIndex > 96 && atIndex < 123) {
                ans += atIndex;
            } else if (atIndex == '(') {
                stack.push(atIndex);
                bracketEncountered = true;
            } else if (bracketEncountered & atIndex != ')') {
                int operatorPriority = priorityMap.containsKey(atIndex) ? priorityMap.get(atIndex) : Integer.MIN_VALUE;
                int stackOperatorPriority = (!stack.isEmpty() && priorityMap.containsKey(stack.peek())) ? priorityMap.get(stack.peek()) : Integer.MAX_VALUE;
                while (!stack.isEmpty() && (stackOperatorPriority <= operatorPriority)) {
                    ans += stack.pop();
                    stackOperatorPriority = (!stack.isEmpty() && priorityMap.containsKey(stack.peek())) ? priorityMap.get(stack.peek()) : Integer.MAX_VALUE;
                }
                stack.push(atIndex);
            } else if (bracketEncountered & atIndex == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    ans += stack.pop();
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                bracketEncountered = false;
            } else {
                if (!stack.isEmpty() && priorityMap.get(stack.peek()) <= priorityMap.get(atIndex)) {
                    int operatorPriority = priorityMap.containsKey(atIndex) ? priorityMap.get(atIndex) : -1;
                    int stackOperatorPriority = (!stack.isEmpty() && priorityMap.containsKey(stack.peek())) ? priorityMap.get(stack.peek()) : Integer.MAX_VALUE;
                    while (!stack.isEmpty() && (stackOperatorPriority <= operatorPriority)) {
                        ans += stack.pop();
                        stackOperatorPriority = (!stack.isEmpty() && priorityMap.containsKey(stack.peek())) ? priorityMap.get(stack.peek()) : Integer.MAX_VALUE;
                    }
                }
                stack.push(atIndex);
            }
            i++;
        }
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }

        return ans;
    }

    public static void main(String args[]) {
        InfixToPostFix infixToPostFix = new InfixToPostFix();
        System.out.println(infixToPostFix.solve("x^y/(a*z)+b"));
        System.out.println(infixToPostFix.solve("a+b*(c^d-e)^(f+g*h)-i"));
    }
}
