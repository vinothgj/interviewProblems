package stackandqueue;

import java.util.ArrayList;

public class MinStack {

    int top = -1, top1 = -1;
    ArrayList<Integer> stack = new ArrayList<Integer>(), minStack = new ArrayList<Integer>();

    public void push(int x) {
        stack.add(x);
        top++;
        if (minStack.isEmpty()) {
            minStack.add(x);
            top1++;
        } else {
            if (x <= getMin()) {
                minStack.add(x);
                top1++;
            }
        }
    }

    public void pop() {
        if (stack.isEmpty() || top == -1) {
            return;
        }
        int val = top();
        stack.remove(top);
        top--;
        if (val == getMin()) {
            minStack.remove(top1);
            top1--;
        }
    }

    public int top() {
        if (stack.isEmpty() || top == -1) {
            return -1;
        }
        return stack.get(top);
    }

    public int getMin() {
        if (minStack.isEmpty() || top1 == -1) {
            return -1;
        }
        return minStack.get(top1);
    }

    public static void main(String arg[]) {
        MinStack minStack = new MinStack();
        minStack.push(10);
        minStack.push(9);
        System.out.println(minStack.getMin());
        minStack.push(8);
        System.out.println(minStack.getMin());
        ;
        minStack.push(7);
        System.out.println(minStack.getMin());
        minStack.push(6);
        System.out.println(minStack.getMin());

        minStack.pop();
        System.out.println(minStack.getMin());

        minStack.pop();
        System.out.println(minStack.getMin());

        minStack.pop();
        System.out.println(minStack.getMin());

        minStack.pop();
        System.out.println(minStack.getMin());

        minStack.pop();
        System.out.println(minStack.getMin());

    }
}

