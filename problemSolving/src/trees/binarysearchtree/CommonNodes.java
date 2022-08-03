package trees.binarysearchtree;

import java.util.HashSet;
import java.util.Set;

public class CommonNodes {
    Set<Integer> set;
    int sum = 0;

    public int solve(TreeNode A, TreeNode B) {
        set = new HashSet<Integer>();
        sum = 0;
        //traverseTree(A);
        //traverseTree(B);
        mTraversalInOrder(A);
        mTraversalInOrder(B);
        return sum;
    }

    void traverseTree(TreeNode node) {
        if (node == null) {
            return;
        }
        traverseTree(node.left);
        if (!set.add(node.val)) {
            sum += node.val;
        }
        traverseTree(node.right);
    }

    void mTraversalInOrder(TreeNode root) {
        TreeNode current, pre;

        if (root == null) {
            return;
        }

        current = root;
        while (current != null) {
            if (current.left == null) {
                if (!set.add(current.val)) {
                    sum += current.val;
                }
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
                    if (!set.add(current.val)) {
                        sum += current.val;
                    }
                    current = current.right;
                }
            }
        }
    }

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

    public static void main(String arg[]) {
        TreeNode inp1 = new TreeNode(5);
        inp1.left = new TreeNode(2);
        inp1.right = new TreeNode(8);

        inp1.left.right = new TreeNode(3);

        inp1.right.right = new TreeNode(15);
        inp1.right.right.left = new TreeNode(9);

        TreeNode inp2 = new TreeNode(7);

        inp2.left = new TreeNode(1);
        inp2.right = new TreeNode(10);

        inp2.left.right = new TreeNode(2);

        inp2.right.right = new TreeNode(15);
        inp2.right.right.left = new TreeNode(11);

        TreeNode inp3 = new TreeNode(7);

        inp3.left = new TreeNode(1);
        inp3.right = new TreeNode(10);

        inp3.left.right = new TreeNode(2);

        inp3.right.right = new TreeNode(15);
        inp3.right.right.left = new TreeNode(11);

        CommonNodes commonNodes = new CommonNodes();
        System.out.println(commonNodes.solve(inp1, inp2));
        System.out.println(commonNodes.solve(inp3, inp2));
    }
}
