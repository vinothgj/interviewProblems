package trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class LeastCommonAncestor {
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

    Deque<Integer> deq = new ArrayDeque<Integer>();
    boolean breakTraverse = false;
    ArrayList<Integer> arr = new ArrayList<Integer>();


    public int lca(TreeNode A, int B, int C) {
        if (A == null) {
            return 0;
        }
        traverseTree(A, B, false);
        ArrayList<Integer> bPath = arr;
        breakTraverse = false;
        arr = new ArrayList<Integer>();
        traverseTree(A, C, false);
        ArrayList<Integer> cPath = arr;

        int n = bPath.size() >= cPath.size() ? cPath.size() : bPath.size(), k = 0, lca = -1;
        while (k < n) {
            if (bPath.get(k) == cPath.get(k)) {
                lca = bPath.get(k);
            } else {
                break;
            }
            k++;
        }
        return lca;
    }

    void traverseTree(TreeNode A, int nodeVal, boolean breakTraverse) {

        if (A == null) {
            deq.push(-1);
            return;
        }

        deq.push(A.val);
        if (A.val == nodeVal) {
            while (!deq.isEmpty()) {
                arr.add(deq.pollLast());
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

    private ArrayList<Integer> traverseTree(TreeNode root) {
        TreeNode current, pre;
        int currentVal = 0;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        if (root == null) {
            return null;
        }
        current = root;
        while (current != null) {
            if (current.left == null) {
                currentVal = current.val;
                arr.add(currentVal);
                current = current.right;
            } else {
                pre = current.left;
                while (pre.right != null && pre.right != current) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                } else {
                    pre.right = null;
                    currentVal = current.val;
                    arr.add(currentVal);
                    current = current.right;
                }
            }
        }
        return arr;
    }

    public static void main(String arg[]) {
        LeastCommonAncestor leastCommonAncestor = new LeastCommonAncestor();
        TreeNode inp = new TreeNode(1);
        inp.left = new TreeNode(2);
        inp.right = new TreeNode(3);
        inp.left.left = new TreeNode(4);
        inp.left.right = new TreeNode(5);

        inp.right.left = new TreeNode(6);
        inp.right.right = new TreeNode(7);
        inp.right.left.left = new TreeNode(8);
        inp.right.left.right = new TreeNode(9);

        //                          1 (1,18)
        //          2  (2,7)                               3 (8,17)
        //  4 (3,4)       5 (5,6)               6(9,14)           7 (15,16)
        //                              8(10,11)       9 (12,13)


        // dictionary - 1 - (1,18), 2 - (2,7) , 3 - (8,17)


        System.out.println(leastCommonAncestor.lca(inp, 2, 5));
    }
}
