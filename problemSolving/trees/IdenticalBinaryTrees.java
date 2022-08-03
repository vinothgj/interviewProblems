package trees;

public class IdenticalBinaryTrees {
    public int isSameTree(TreeNode A, TreeNode B) {

        int ans = isIdenticalTree(A, B) ? 1 : 0;
        return ans;

    }

    boolean isIdenticalTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val == root2.val) {
            return isIdenticalTree(root1.left, root2.left) && isIdenticalTree(root1.right, root2.right);
        }
        return false;
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
        IdenticalBinaryTrees identicalBinaryTrees = new IdenticalBinaryTrees();
        TreeNode inp1 = new TreeNode(5);
        TreeNode inp2 = new TreeNode(10);
        //TreeNode inp3 = new TreeNode(3);
        inp1.left = inp2;
        //inp1.right = inp3;

        TreeNode inp11 = new TreeNode(5);
        //TreeNode inp12 = new TreeNode(3);
        //TreeNode inp13 = new TreeNode(2);
        //inp11.left = inp12;
        //inp11.right = inp13;

        System.out.println(identicalBinaryTrees.isSameTree(inp1, inp11));
    }
}
