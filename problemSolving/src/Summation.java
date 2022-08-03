public class Summation {

    public int solve(int A) {
        /*int P = 1000000007;
        long product = A * (A - 1);
        //System.out.println(product);
        long sum = power(3, (A - 2), P);
        //System.out.println(sum);
        //long res = (sum * product)%P;
        //System.out.println(res%P);
        return (int) ((sum % P * product % P) % P);*/

        int P = 1000000007;
        long product = A * (A - 1);
        long sum = power(3, (A - 2), P);
        long result = ((sum % P) * (product%P))%P;
        return ((int) ((sum%P * product%P) % P))%P;
    }

    static long power(long a, int b, int m) {
        if (b == 0) {
            return 1;
        }
        if (b % 2 == 0) {
            return power((1L * a * a), (b / 2), m);
        } else {
            return a * power((1L * a * a), ((b - 1) / 2), m);
        }
    }

    public static void main(String arg[]) {
        Summation summation = new Summation();
        System.out.println(summation.solve(90));
    }
}
