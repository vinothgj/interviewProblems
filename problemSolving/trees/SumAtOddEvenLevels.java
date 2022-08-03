package trees;

import java.util.HashMap;
import java.util.Map;

public class SumAtOddEvenLevels {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    int internalLevel = 0;
    int sumEven = 0, sumOdd = 0;

    public int solve(TreeNode A) {
        sumEven = 0;
        sumOdd = 0;
        sumAtOddEven(A, 0, 0);
        return sumEven - sumOdd;
    }

    void sumAtOddEven(TreeNode node, int dist, int level) {
        if (node == null) {
            return;
        }

        if (level % 2 == 0) {
            internalLevel = 2;
            sumEven += node.val;
            map.put(internalLevel, sumEven);
        } else {
            internalLevel = 1;
            sumOdd += node.val;
            map.put(internalLevel, sumOdd);
        }

        sumAtOddEven(node.left, dist - 1, level + 1);
        sumAtOddEven(node.right, dist + 1, level + 1);
    }

    class Info {
        int val;
        int level;

        public Info(int val, int level) {
            this.val = val;
            this.level = level;
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
        SumAtOddEvenLevels sumAtOddEvenLevels = new SumAtOddEvenLevels();

        TreeNode inp1 = new TreeNode(1);
        TreeNode inp2 = new TreeNode(2);
        TreeNode inp3 = new TreeNode(3);
        inp1.left = inp2;
        inp1.right = inp3;

        TreeNode inp4 = new TreeNode(4);
        inp2.left = inp4;

        TreeNode inp5 = new TreeNode(5);
        inp2.right = inp5;

        TreeNode inp6 = new TreeNode(6);
        inp3.left = inp6;

        TreeNode inp7 = new TreeNode(7);
        inp3.right = inp7;

        TreeNode inp8 = new TreeNode(8);
        inp4.left = inp8;

        TreeNode inp11 = new TreeNode(1);
        TreeNode inp12 = new TreeNode(2);
        TreeNode inp13 = new TreeNode(10);
        TreeNode inp14 = new TreeNode(4);

        inp11.left = inp12;
        inp11.right = inp13;
        inp12.right = inp14;

        System.out.println(sumAtOddEvenLevels.solve(inp1));
        System.out.println(sumAtOddEvenLevels.solve(inp11));
    }
}
