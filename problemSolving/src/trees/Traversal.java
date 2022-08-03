package trees;

import java.util.ArrayList;
import java.util.Stack;

public class Traversal {
    TreeNode root;
    ArrayList<Integer> list = new ArrayList<Integer>();

    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        Stack<TreeNode> S = new Stack<TreeNode>();
        // Check for empty tree
        if (A == null) {
            return list;
        }
        S.push(A);
        TreeNode prev = null;
        while (!S.isEmpty()) {
            TreeNode current = S.peek();

            /* go down the tree in search of a leaf an if so process it
            and pop stack otherwise move down */
            if (prev == null || prev.left == current ||
                    prev.right == current) {
                if (current.left != null) {
                    S.push(current.left);
                } else if (current.right != null) {
                    S.push(current.right);
                } else {
                    S.pop();
                    list.add(current.val);
                }

                /* go up the tree from left node, if the child is right
                push it onto stack otherwise process parent and pop
                stack */
            } else if (current.left == prev) {
                if (current.right != null) {
                    S.push(current.right);
                } else {
                    S.pop();
                    list.add(current.val);
                }

                /* go up the tree from right node and after coming back
                from right node process parent and pop stack */
            } else if (current.right == prev) {
                S.pop();
                list.add(current.val);
            }

            prev = current;
        }
        return list;
    }


    ArrayList<Integer> ans = new ArrayList<Integer>();

    void inorder(TreeNode root) {
        if (root == null) {
            return;
        }


        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode curr = root;

        // traverse the tree
        while (curr != null || s.size() > 0) {
            while (curr != null) {
                s.push(curr);
                curr = curr.left;
            }

            curr = s.pop();

            ans.add(curr.val);


            curr = curr.right;
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
        Traversal traversal = new Traversal();
        TreeNode inp1 = new TreeNode(1);
        TreeNode inp2 = new TreeNode(6);
        TreeNode inp3 = new TreeNode(2);
        inp1.left = inp2;
        inp1.right = inp3;
        inp2.left = null;
        inp2.right = null;
        TreeNode inp4 = new TreeNode(3);
        inp3.left = inp4;

        System.out.println(traversal.postorderTraversal(inp1));
    }
}
