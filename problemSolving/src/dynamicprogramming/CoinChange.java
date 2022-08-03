package dynamicprogramming;

public class CoinChange {

    public static void main(String arg[]) {
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinchange2(new int[]{1, 2, 3}, 4));
        //System.out.println(coinChange.coinchange2(new int[]{18, 24, 23, 10, 16, 19, 2, 9, 5, 12, 17, 3, 28, 29, 4, 13, 15, 8}, 458));
        System.out.println(coinChange.coinchange2(new int[]{1, 3, 4}, 10));
        System.out.println(coinChange.coinchange2(new int[]{1, 3, 4, 5}, 15));
        System.out.println(coinChange.coinchange2(new int[]{1, 2, 3, 5, 10}, 100));
    }

    public int coinchange2(int[] A, int B) {
        return ways(A, B, 0);
    }

    int ways(int[] src, int sum, int idx) {

        if (idx < src.length && sum == 0) {
            return 1;
        }
        if ((idx > src.length - 1 && sum > 0) || (idx < src.length && sum < 0)) {
            return 0;
        }

        return (ways(src, sum, idx + 1) % 1000007) + (ways(src, sum - src[idx], idx) % 1000007);

    }
}
