// Java program to find numbers that are product
// of exactly two distinct prime numbers

class LuckyNumber {

    static int findNumbers(int N) {

        int[] result = new int[N+1];

        for (int i = 0; i < N+1; i++) {
            result[i] = 0;
            //System.out.println(result[i]);
        }


        for (int i = 2; i <= N; i++) {
            if (result[i] == 0) {
                int multiple = 2;
                result[i] = result[i] + 1;
                int factor = i * multiple;
                while (factor <= N) {
                    result[factor] = result[factor] + 1;
                    multiple++;
                    factor = i * multiple;
                }
            }
        }

        int count = 0;
        for (int i = 2; i <= N; i++) {

            //System.out.println("i = " + i + " "  + result[i] + " ");
            if (result[i] == 2) {
                //System.out.println("i = " + i + " "  + result[i] + " ");
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int N = 100;

        System.out.println(findNumbers(N));
    }
}
// This Code is Contributed by mits
