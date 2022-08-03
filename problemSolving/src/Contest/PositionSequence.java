package Contest;

public class PositionSequence {
    public int solve(int A, int B) {
        int i = 1, count = 0, temp = B, ans = 0;
        while (temp > 0) {
            int dividor = (A - count);
            if (temp % dividor == 0) {
                int divisor = temp / i;
                if ((divisor + count) == A) {
                    ans = divisor - 1;
                    break;
                }
            } else {
                temp -= i;
                i++;
                count++;
            }
        }

        return ans;

    }

    public int[] solve(int[] A, int[] B) {
        int n = B.length, j = 0;
        int[] prefix = new int[A.length];
        int[] ans = new int[n];

        for (int i = 0; i < A.length; i++) {
            if (i == 0) {
                prefix[i] = A[i];
            } else {
                prefix[i] = A[i] + prefix[i - 1];
            }
        }

        for (int i = 0; i < n; i++) {
            int bVal = B[i];
            int k = A.length - 1;

            while (k >= 0) {
                if (bVal > prefix[k]) {
                    break;
                } else {
                    k--;
                }
            }
            ans[j++] = k + 1;
        }

        return ans;

    }

    public static void main(String arg[]) {
        PositionSequence positionSequence = new PositionSequence();
        System.out.println(positionSequence.solve(8, 21));
        System.out.println(positionSequence.solve(3, 5));
        System.out.println(positionSequence.solve(6, 7));
        positionSequence.solve(new int[]{23, 36, 58, 59}, new int[]{3, 207, 62, 654, 939, 680, 760});
    }
}
