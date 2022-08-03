package gcd;

import java.math.BigDecimal;

public class EnumGCD {

    public String solve(String A, String B) {

        BigDecimal bd1 = new BigDecimal(A);
        BigDecimal bd2 = new BigDecimal(B);

        if(A.equals(B) || A.equals("1")) {
            return A;
        }

        BigDecimal zero = new BigDecimal("0");

        if(bd1.equals(zero)) {
            return B;
        }

        if(bd2.equals(zero)) {
            return A;
        }


        BigDecimal ans = bd2.subtract(bd1);
        System.out.println("Answer : " + ans);

        BigDecimal divisor = new BigDecimal("2");
        BigDecimal remainder = new BigDecimal("1");

        System.out.println("Reminder : " + ans.remainder(divisor));

        if(ans.remainder(divisor).equals(remainder))
            return "1";
        else
            return B;
    }

    BigDecimal gcd(BigDecimal bd1, BigDecimal bd2) {

        if(bd1.add(BigDecimal.ONE).equals(bd2)) {
            return BigDecimal.ONE;
        }

        BigDecimal ONE = bd1.add(BigDecimal.ONE);
        BigDecimal TWO = ONE.add(BigDecimal.ONE);

        return gcd(gcd(bd1,ONE),gcd(TWO,bd2));

    }

    public static void main(String args[]) {
        EnumGCD enumGCD = new EnumGCD();
        System.out.println(enumGCD.solve("100","100000"));
    }

}
