package Greedy;

import java.util.ArrayList;

public class CoinProblem {

    ArrayList<Integer> coins;

    public int solve(int A) {
        coins = new ArrayList<>();
        int count = 0, val = A;
        constructDenomination(val);
        int i = coins.size();
        while (val > 0) {
            if (val < coins.get(i - 1)) {
                i--;
            } else {
                val -= coins.get(i - 1);
                count++;
            }
        }
        return count;
    }

    void constructDenomination(int cost) {
        int base = 5, sum = 1;
        coins.add(sum);
        while (cost > sum) {
            sum *= base;
            coins.add(sum);
        }
    }

    public static void main(String arg[]) {
        CoinProblem coinProblem = new CoinProblem();
        System.out.println(coinProblem.solve(47));
        System.out.println(coinProblem.solve(9));
    }


}
