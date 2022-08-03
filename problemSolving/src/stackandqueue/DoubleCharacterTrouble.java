package stackandqueue;

import java.util.Stack;

public class DoubleCharacterTrouble {
    public String solve(String A) {
        Stack<Character> stack = new Stack<Character>();
        int n = A.length();
        stack.push(A.charAt(n - 1));
        for (int i = n - 2; i >= 0; i--) {
            char atIndex = A.charAt(i);
            if (!stack.isEmpty() && stack.peek() == atIndex) {
                stack.pop();
            } else {
                stack.push(atIndex);
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty())
        {
            ans.append(stack.peek());
            stack.pop();
        }
        return ans.toString();
    }

    public static void main(String arg[]) {
        DoubleCharacterTrouble doubleCharacterTrouble = new DoubleCharacterTrouble();
        System.out.println(doubleCharacterTrouble.solve("aaaaa"));
        System.out.println(doubleCharacterTrouble.solve("abccbc"));
        System.out.println(doubleCharacterTrouble.solve("aba"));
        System.out.println(doubleCharacterTrouble.solve("acbbcaabcdeffehgheg"));
    }
}
