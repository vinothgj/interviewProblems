package trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

public class LevelOrder {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        TreeNode root = A;
        if (root == null) {
            return new ArrayList<ArrayList<Integer>>();
        }
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.push(root);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        int level_size = 1, counter = 1;

        while (!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            for (int i = 0; i < level_size; i++) {
                TreeNode curr = queue.peekFirst();
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
                level.add(curr.val);
                queue.pollFirst();
            }
            ans.add(level);
            level_size = queue.size();
            counter++;
        }
        return ans;
    }

    public ArrayList<ArrayList<Integer>> zigzagOrder(TreeNode A) {
        TreeNode root = A;
        if (root == null) {
            return new ArrayList<ArrayList<Integer>>();
        }
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.push(root);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        int level_size = 1, counter = 1;

        while (!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            ArrayList<Integer> conv = new ArrayList<Integer>();
            for (int i = 0; i < level_size; i++) {
                TreeNode curr = queue.peekFirst();
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
                level.add(curr.val);
                queue.pollFirst();
            }
            if (counter % 2 == 0) {
                for (int j = level.size() - 1; j >= 0; j--) {
                    conv.add(level.get(j));
                }
                ans.add(conv);
            } else {
                ans.add(level);
            }

            level_size = queue.size();
            counter++;
        }
        return ans;
    }

    public ArrayList<Integer> postorderTraversal(TreeNode A) {

        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        TreeNode head = A;
        ArrayList<Integer> innerArray = new ArrayList<Integer>();

        if (head != null) {
            s1.push(head);
            while (!s1.isEmpty()) {
                TreeNode curr = s1.pop();
                s2.push(curr);
                if (curr.left != null) {
                    s1.push(curr.left);
                }
                if (curr.right != null) {
                    s1.push(curr.right);
                }
            }
            while (!s2.isEmpty()) {

                TreeNode curr = s1.pop();
                if (curr.val != -1) {
                    innerArray.add(curr.val);
                }
            }
        }
        return innerArray;
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

    public static void main(String args[]) {
        LevelOrder levelOrder = new LevelOrder();
        TreeNode inp1 = new TreeNode(3);
        TreeNode inp2 = new TreeNode(9);
        TreeNode inp3 = new TreeNode(20);
        inp1.left = inp2;
        inp1.right = inp3;
        inp2.left = new TreeNode(10);
        inp2.right = new TreeNode(11);
        TreeNode inp4 = new TreeNode(15);
        TreeNode inp5 = new TreeNode(7);
        inp3.left = inp4;
        inp3.right = inp5;
        inp4.left = new TreeNode(12);
        inp4.right = new TreeNode(14);

        System.out.println(levelOrder.levelOrder(inp1));
    }
}
