package primenumbers;

import java.util.ArrayList;
import java.util.Arrays;

public class FactorialArray {

    public int solve(int[] A) {
        int size = A.length;
        Arrays.sort(A);
        int max = A[size - 1];
        ArrayList<Integer> resp = sieveOfEratosthenes(max);

        /*for (int k = 0; k < size; k++) {
            System.out.print(A[k] + " ");
        }

        System.out.println(); */

        int i = 0, sum = 0, nextVal = 0, val = 0;

        while(A[i] < 2) {
            i++;
        }

        for (int j = 0; j < resp.size(); j++) {
            val = resp.get(j);
            int count = 0;

            if ((j + 1) < resp.size()) {

                nextVal = resp.get(j + 1);

                /*System.out.println("Between the primes " + val + " and " + nextVal);
                System.out.println("A of (i) " + i + " " + A[i]);*/

                while (A[i] >= val && A[i] < nextVal) {
                    count++;
                    i++;
                }
            } else {
                count = size - i;
            }
            //System.out.println("Count : " + count);
            sum += power(2, count) - 1;
            //System.out.println("Sum : " + sum);
        }
        return sum;
    }

    ArrayList<Integer> sieveOfEratosthenes(int n) {
        boolean prime[] = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            prime[i] = true;
        }
        for (int p = 2; p * p <= n; p++) {
            if (prime[p] == true) {
                // Update all multiples of p
                for (int i = p * p; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }
        ArrayList<Integer> resp = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (prime[i] == true) {
                resp.add(i);
//                System.out.println(i);
            }
        }
        System.out.println(resp.size());
        return resp;
    }

    int power(int base, int power) {
        int i = 1, ans = 1;
        while (i <= power) {
            ans = ans * base;
            i++;
        }
        return ans;
    }

    public static void main(String args[]) {
        FactorialArray factorial = new FactorialArray();
        //System.out.println(factorial.solve(new int[]{2, 3, 2, 3}));
        //System.out.println(factorial.solve(new int[]{2, 3, 4}));
        //System.out.println(factorial.solve(new int[]{5, 10, 3, 7, 4}));

        System.out.println(factorial.solve(new int[]{251, 923, 561, 230, 100, 399, 542, 198, 548, 892, 721, 781, 174, 809, 9, 232, 165, 861, 36, 837, 377, 313, 475, 269, 210, 530, 940, 570, 24, 434, 764, 275, 709, 325, 505, 161, 724, 47, 359, 625, 291, 81, 406, 465, 242, 767, 698, 408, 629, 86, 597, 358, 399, 72, 979, 962, 603, 919, 884, 627, 353, 1, 254, 414, 678, 111, 575, 755, 511, 287, 380, 802, 720, 138, 620, 314, 905, 670, 74, 886, 756, 671, 244, 508, 744, 224, 822, 347, 495, 706, 326, 201, 707, 580, 615, 386, 43, 543, 141, 554}));

        //251, 923, 561, 230, 100, 399, 542, 198, 548, 892, 721, 781, 174, 809, 9, 232, 165, 861, 36, 837, 377, 313, 475, 269, 210, 530, 940, 570, 24, 434, 764, 275, 709, 325, 505, 161, 724, 47, 359, 625, 291, 81, 406, 465, 242, 767, 698, 408, 629, 86, 597, 358, 399, 72, 979, 962, 603, 919, 884, 627, 353, 1, 254, 414, 678, 111, 575, 755, 511, 287, 380, 802, 720, 138, 620, 314, 905, 670, 74, 886, 756, 671, 244, 508, 744, 224, 822, 347, 495, 706, 326, 201, 707, 580, 615, 386, 43, 543, 141, 554
    }

}
