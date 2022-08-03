package trees.binarysearchtree;

import java.util.ArrayList;
import java.util.Collections;

public class ValidBST {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    ArrayList<Integer> ans = new ArrayList<Integer>();

    public int isValidBST(TreeNode root) {

      /*  ArrayList<Integer> res = postOrderTraversal(root);
        if(Collections.max(res) < root.val && Collections.min())*/
        return 0;

    }

    ArrayList<Integer> postOrderTraversal(TreeNode node) {
        ans = new ArrayList<Integer>();
        if (node == null) {
            return ans;
        }
        ArrayList<Integer> left = postOrderTraversal(node.left);
        ArrayList<Integer> right = postOrderTraversal(node.right);

        if (left.size() == 0 && right.size() == 0) {
            ans.add(node.val);
            ans.add(node.val);
        } else if (left.size() == 0) {
            ans.add(node.val);
            ans.add(Collections.max(right));
        } else if (right.size() == 0) {
            ans.add(Collections.min(left));
            ans.add(node.val);
        } else {
            ans.add(Collections.min(left));
            ans.add(Collections.max(right));
        }
        return ans;
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
        ValidBST validBST = new ValidBST();
       /* TreeNode inp1 = new TreeNode(5);
        TreeNode inp2 = new TreeNode(3);
        TreeNode inp3 = new TreeNode(12);
        inp1.left = inp2;
        inp1.right = inp3;
        TreeNode inp4 = new TreeNode(4);
        TreeNode inp5 = new TreeNode(2);
        inp2.right = inp4;
        inp2.left = inp5;
        TreeNode inp17 = new TreeNode(17);
        TreeNode inp15 = new TreeNode(11);
        inp3.left = inp15;
        inp3.right = inp17;*/

        /*TreeNode inp40 = new TreeNode(40);
        inp40.left = new TreeNode(35);
        inp40.right = new TreeNode(41);

        inp40.left.left = new TreeNode(34);
        inp40.left.right = new TreeNode(37);
        inp40.right.right = new TreeNode(46);

        inp40.left.left.left = new TreeNode(31);
        inp40.left.right.left = new TreeNode(36);
        inp40.left.right.right = new TreeNode(38);

        inp40.right.right.left = new TreeNode(45);
        inp40.right.right.right = new TreeNode(47);


        inp40.left.left.left.left = new TreeNode(29);
        inp40.left.left.left.right = new TreeNode(32);
        inp40.left.right.right.right = new TreeNode(39);
        inp40.right.right.left.left = new TreeNode(43);

        inp40.left.left.left.left.left = new TreeNode(28);
        inp40.left.left.left.left.right = new TreeNode(30);
        inp40.left.left.left.right.right = new TreeNode(33);
        inp40.right.right.left.left.left = new TreeNode(42);
        inp40.right.right.left.left.right = new TreeNode(44);
        inp40.left.left.left.left.left.left = new TreeNode(25);
        inp40.left.left.left.left.left.left.left = new TreeNode(24);
        inp40.left.left.left.left.left.left.right = new TreeNode(26);
        inp40.left.left.left.left.left.left.left.right = new TreeNode(27);*/

        TreeNode inp4 = new TreeNode(4);
        inp4.left = new TreeNode(3);
        inp4.right = new TreeNode(7);

        inp4.left.left = new TreeNode(2);

        inp4.right.left = new TreeNode(5);
        inp4.right.right = new TreeNode(12);

        inp4.right.left.right = new TreeNode(6);

        inp4.right.right.left = new TreeNode(9);
        inp4.right.right.right = new TreeNode(14);

        inp4.right.right.left.left = new TreeNode(8);
        inp4.right.right.left.right = new TreeNode(10);

        inp4.right.right.left.right.right = new TreeNode(11);

        inp4.right.right.left.right.right.right = new TreeNode(13);

        System.out.println(validBST.isValidBST(inp4));
    }
}
