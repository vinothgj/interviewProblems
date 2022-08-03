package bitmanipulation;

public class SingleNumber2 {

    public int singleNumber(final int[] A) {

        int setBits = 0;
        int k = 0;
        int num = 0;
        for (int i = 0; i < 31; i++) {
            for (int j = 0; j < A.length; j++) {
                if ((A[j] & (1 << i)) > 0) {
                    setBits++;
                }
            }
            num = num + (setBits % 3) * (1 << k);
            k++;
            setBits = 0;
        }

        return num;
    }

    public static void main(String arg[]) {
        SingleNumber2 singleNumber2 = new SingleNumber2();
        System.out.println(singleNumber2.singleNumber(new int[]{1, 2, 4, 3, 3, 2, 2, 3, 1, 1}));
    }

}
