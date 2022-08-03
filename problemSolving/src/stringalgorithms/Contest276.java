package stringalgorithms;

public class Contest276 {

    public String[] divideString(String s, int k, char fill) {
        int n = s.length(), balance = (n % k), i = 0;
        if (balance != 0) {
            while ((n + i) < n + (k - balance)) {
                s += fill;
                i++;
            }
        }

        int len = (s.length() / k), q = 0;
        String[] ans = new String[len];

        for (int j = 0; j < s.length(); j += k) {
            ans[q++] = s.substring(j, j + k);
        }
        return ans;
    }

    public int minMoves(int target, int maxDoubles) {
        if (maxDoubles == 0) {
            return (target - 1);
        }
        int minMoves = 0;

        while (maxDoubles > 0 && target > 1) {
            if (target % 2 == 0) {
                target = target / 2;
            } else {
                target = target - 1;
                minMoves++;
                target = target / 2;
            }
            minMoves++;
            maxDoubles--;
        }

        if (target != 1) {
            minMoves += (target - 1);
        }

        return minMoves;

    }

    public long mostPoints(int[][] questions) {
        long sum = 0;
        int k = 0;
        long max = Integer.MIN_VALUE;
        for (int i = 0; i < questions.length; i++) {
            k = i;
            while (k < questions.length) {
                sum += questions[k][0];
                k = k + questions[k][1] + 1;
            }
            max = Math.max(sum, max);
            sum = 0;
        }
        return max;
    }

    public static void main(String arg[]) {
        Contest276 contest276 = new Contest276();
        /*contest276.divideString("abcdefghij", 3, 'x');
        contest276.minMoves(19, 2);
        contest276.minMoves(10, 4);*/
        System.out.println(contest276.minMoves(766972377, 92));
        /*int[][] ip = new int[5][2];
        // [[12,46],[78,19],[63,15],[79,62],[13,10]]
        // [13,10], [63,15], [78,19], [12,46], [79,62]

        ip[0][0] = 1;
        ip[0][1] = 1;

        ip[1][0] = 2;
        ip[1][1] = 2;

        ip[2][0] = 3;
        ip[2][1] = 3;

        ip[3][0] = 4;
        ip[3][1] = 4;

        ip[4][0] = 5;
        ip[4][1] = 5;

        contest276.mostPoints(ip);*/
    }
}
