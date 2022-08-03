package trees;

public class BalancedBinaryTree {
    public int isBalanced(TreeNode A) {
        Info info = isHeightBalanced(A);
        if (info.balanced) {
            return 1;
        }
        return 0;
    }

    Info isHeightBalanced(TreeNode root) {
        if (root == null) {
            return new Info(0, true);
        }
        Info leftInfo = isHeightBalanced(root.left);
        Info rightInfo = isHeightBalanced(root.right);

        int height = 1 + Math.max(leftInfo.height, rightInfo.height);
        boolean isBalanced = (Math.abs(leftInfo.height - rightInfo.height) <= 1) &&
                leftInfo.balanced && rightInfo.balanced;
        return new Info(height, isBalanced);
    }

    class Info {
        int height;
        boolean balanced;

        Info(int height, boolean balanced) {
            this.height = height;
            this.balanced = balanced;
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

    public static void main(String args[]) {
        BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();
        TreeNode inp1 = new TreeNode(1);
        TreeNode inp2 = new TreeNode(2);
        TreeNode inp3 = new TreeNode(3);
        inp1.left = inp2;
        inp1.right = inp3;
        /*inp2.left = null;
        inp2.right = null;*/
        //TreeNode inp4 = new TreeNode(3);
        /*inp3.left = inp4;*/
        System.out.println(balancedBinaryTree.isBalanced(inp1));
    }

}
