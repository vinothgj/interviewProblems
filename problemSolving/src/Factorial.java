public class Factorial {


    static int factorial(int n) {
        if(n == 0) {
            return 1;
        }

        return ((n%10) * factorial(n-1));
    }

    public static void main(String args[]) {
        Factorial factorial = new Factorial();

        System.out.println(factorial.factorial(5));
    }
}
