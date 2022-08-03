public class BitWisePairSum {

    public int cntBits(int[] A) {
        return bitsSumwisePair(A);
    }

    static int bitsSumwisePair(int[] a) {
        int res = 0;
        int mod = 1000000007;
        int count = 0;
        int len = a.length;

        for(int i = 0; i < 32; i ++) {
            count = 0;
            for(int j = 0; j < len; j++) {
                if(((a[j]>>i) & 1) == 1){
                    count++;
                }
            }
            res += (2 * count * (len - count));
            res %= mod;
        }
        System.out.println(res);
        return res;
    }

    public static void main(String args[]) {
        BitWisePairSum bitWisePairSum = new BitWisePairSum();
        bitWisePairSum.cntBits(new int[] {2, 3});
        //bitWisePairSum.cntBits(new int[] {1, 3, 5});
    }
}
