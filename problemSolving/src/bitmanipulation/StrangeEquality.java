package bitmanipulation;

public class StrangeEquality {

    public int solve(int A) {
        String binValue = decimalToBinary(A);
        int count = binValue.length(), greatestInt = 0, k = 0;
        int smallestInt = (1 << count);

        for (int i = (count-1); i >= 0; i--) {
            if (binValue.charAt(i) == '0') {
                greatestInt += (1 << k);
            }
            k++;
        }
        return (smallestInt ^ greatestInt);
    }

    static String decimalToBinary(int a) {
        String str = "";
        while (a > 0) {
            str = (a % 2) + str;
            a = a / 2;
        }

        return str;
    }

    public static void main(String args[]) {
        StrangeEquality strangeEquality = new StrangeEquality();
        System.out.println(strangeEquality.solve(5));
        System.out.println(strangeEquality.solve(10));
        System.out.println(strangeEquality.solve(20));
        System.out.println(strangeEquality.solve(30));
    }
}

