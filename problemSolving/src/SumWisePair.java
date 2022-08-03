public class SumWisePair {

    public int cntBits(int[] A) {
        return bitsSumwisePair(A);
    }

    static int bitsSumwisePair(int[] a) {
        int res = 0, mod = 1000000007;
        int onesCount = 0, len = a.length;

        for(int i = 0; i < 32; i ++) {
            onesCount = 0;
            for(int j = 0; j < len; j++) {
                if(((a[j]>>i) & 1) == 1){
                    onesCount++;
                }
            }
            int zerosCount = len - onesCount;
            res = (res + (2 * onesCount * zerosCount)) % mod;
            //res %= mod;
        }
        //System.out.println(res);
        return res;
    }

    public static void main(String args[]) {
        SumWisePair sumWisePair = new SumWisePair();
        System.out.println(sumWisePair.cntBits(new int[] {1, 3, 5}));
    }
}
