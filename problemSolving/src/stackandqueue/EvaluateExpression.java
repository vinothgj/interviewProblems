package stackandqueue;

import java.util.Stack;

public class EvaluateExpression {
    public int evalRPN(String[] A) {

        Stack<String> stack = new Stack<String>();
        int n = A.length, var1 = 0, var2 = 0, var3 = 0;
        String operations = "+-*/";
        try {
            for (int i = 0; i < n; i++) {
                String element = A[i];
                if (operations.contains(element)) {

                    var1 = Integer.valueOf(stack.pop());
                    var2 = Integer.valueOf(stack.pop());

                    if (element.equals("+")) {
                        var3 = var1 + var2;
                    } else if (element.equals("-")) {
                        var3 = var2 - var1;
                    } else if (element.equals("*")) {
                        var3 = var1 * var2;
                    } else {
                        var3 = var2 / var1;
                    }
                    stack.push(String.valueOf(var3));
                } else {
                    stack.push(element);
                }
            }
            var3 = Integer.valueOf(stack.pop());
        } catch (NumberFormatException ex) {
            throw ex;
        }

        return var3;
    }

    public static void main(String args[]) {
        EvaluateExpression evaluateExpression = new EvaluateExpression();
        //System.out.println(evaluateExpression.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        //System.out.println(evaluateExpression.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println(evaluateExpression.evalRPN(new String[]{"2", "2", "/"}));

    }
}
