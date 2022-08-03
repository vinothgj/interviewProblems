package bitmanipulation;

public class SumWisePair {
    static int bitsSumwisePair(int[] a) {
        int mod = 1000000007;
        int n = a.length;
        long total = 0;
        for (int i = 0; i < 32; i++) {
            int setBits = 0;
            for (int j = 0; j < a.length; j++) {
                if ((a[j] & (1 << i)) > 0) {
                    setBits++;
                }
            }
            total += 2 * (long) setBits * (n - (long) setBits);
            total = (total % mod);
        }
        return (int) (total);
    }

    static int bitsSumwisePai1r(int[] a) {
        long res = 0, mod = 1000000007;
        int onesCount = 0, len = a.length;

        for (int i = 0; i < 32; i++) {
            onesCount = 0;
            for (int j = 0; j < len; j++) {
                if ((a[j] & (1 << i)) > 0) {
                    onesCount++;
                }
            }
            long zerosCount = len - (long) onesCount;
            res += (2 * (long) onesCount * zerosCount);
            res %= mod;
        }
        return (int) res;
    }

    public int cntBits(int[] A) {
        return bitsSumwisePair(A);
    }
}
