package trees;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class PathSum {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }

    }

    Stack<Integer> stack;
    int sum;
    boolean canContinue;
    Deque<Integer> deq = new ArrayDeque<Integer>();
    boolean breakTraverse = false;

    public int hasPathSum(TreeNode A, int B) {
        return findPathSum(A, B) ? 1 : 0;
    }

    boolean findPathSum(TreeNode node, int sum) {
        if (node == null) {
            return false;
        }
        sum = sum - node.val;
        if (node.left == null && node.right == null) {
            return (sum == 0);
        }
        return (findPathSum(node.left, sum) || findPathSum(node.right, sum));
    }

    private void traverseTree(TreeNode node, int target) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            stack.push(node.val);
            sum += node.val;
            if (sum == target) {
                canContinue = false;
                return;
            } else {
                int popLeft = stack.pop();
                sum -= popLeft;
            }
        } else {
            stack.push(node.val);
            sum += node.val;
        }

        if (canContinue) {
            traverseTree(node.left, target);
        }
        if (canContinue) {
            traverseTree(node.right, target);
        }

        if (canContinue && !stack.empty()) {
            int popNode = stack.pop();
            sum -= popNode;
        }
    }

    void traverseTree(LeastCommonAncestor.TreeNode A, int nodeVal, boolean breakTraverse) {

        if (A == null) {
            deq.push(-1);
            return;
        }

        deq.push(A.val);
        if (A.val == nodeVal) {
            while (!deq.isEmpty()) {
                sum += deq.pollLast();
            }
            breakTraverse = true;
        }
        if (!breakTraverse) {
            traverseTree(A.left, nodeVal, breakTraverse);
        }
        if (!breakTraverse && !deq.isEmpty()) {
            deq.pop();
        }
        if (!breakTraverse) {
            traverseTree(A.right, nodeVal, breakTraverse);
        }
        if (!breakTraverse && !deq.isEmpty()) {
            deq.pop();
        }
        return;
    }

    void mTraversalInOrder(TreeNode root) {
        TreeNode current, pre;

        if (root == null) {
            return;
        }

        current = root;
        while (current != null) {
            if (current.left == null) {
                sum += current.val;
                current = current.right;
            } else {
                pre = current.left;
                while (pre.right != null
                        && pre.right != current) {
                    pre = pre.right;
                }

                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                } else {
                    pre.right = null;
                    sum += current.val;
                    current = current.right;
                }
            }
        }
    }

    public static void main(String arg[]) {
        PathSum pathSum = new PathSum();
        TreeNode inp = new TreeNode(5);
        inp.left = new TreeNode(4);
        inp.right = new TreeNode(8);

        inp.left.left = new TreeNode(11);

        inp.left.left.left = new TreeNode(7);
        inp.left.left.right = new TreeNode(2);

        inp.right.left = new TreeNode(13);
        inp.right.right = new TreeNode(4);

        /*inp.right.right.right = new TreeNode(1);*/


        System.out.println(pathSum.hasPathSum(inp, 17));
    }
}
