package bitmanipulation;

public class DivideIntegers {

    public int divide(int A, int B) {
        if (B == 1) {
            return A;
        }
        if (B == -1) {
            return ((1 << 31) - 1);
        }

        int signA = 1, signB = 1, ans = 0, positiveOfB = 0, diff = 0, len = 31;
        if( A < 0 && B < 0 && A > (1<<31)) {

        }
        /*if (A < 0) {
            signA = -1;
        }
        if (B < 0) {
            signB = -1;
        }

        if (A < 0) {
            A = A * signA;
        }

        if (B < 0) {
            B = B * signB;
        if (A == (1 << 31)) {
            A = ((1 << 31) - 1);

        }*/
        //}
        /*len = (B + "").length();
        if(len < 5)
            len = 31;*/
        for (int i = len; i >= 0; i--) {
            positiveOfB = (B << i);
            System.out.println(positiveOfB);
            if (positiveOfB > 0) {
                diff = A - positiveOfB;
                if (diff >= 0) {
                    System.out.println(i);
                    A = diff;
                    ans += (1 << i);
                }
            }
        }

        return ((signA / signB) * ans);

    }

    public static void main(String arg[]) {
        DivideIntegers divideIntegers = new DivideIntegers();
        System.out.println(divideIntegers.divide(-714404731, -1743086));
    }
}
