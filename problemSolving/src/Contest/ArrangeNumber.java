package Contest;

public class ArrangeNumber {
    // Java program for finding smallest number
// from digits of given number

    // function to find the smallest number
    static int smallest(int num) {
        int[] freq = new int[10];
        boolean is_pos = (num > 0);
        num = Math.abs(num);
        while (num > 0) {
            int d = num % 10;
            freq[d]++;
            num = num / 10;
        }

        int result = 0;

        if (is_pos) {
            for (int i = 1; i <= 9; i++) {
                if (freq[i] != 0) {
                    result = i;
                    freq[i]--;
                    break;
                }
            }
            for (int i = 0; i <= 9; i++) {
                while (freq[i]-- != 0) {
                    result = result * 10 + i;
                }
            }
        } else {
            for (int i = 9; i >= 1; i--) {
                if (freq[i] != 0) {
                    result = i;
                    freq[i]--;
                    break;
                }
            }

            for (int i = 9; i >= 0; i--) {
                while (freq[i]-- != 0) {
                    result = result * 10 + i;
                }
            }
            result = -result;
        }
        return result;
    }

    // Driver Program
    public static void main(String args[]) {
        int num = 570107;
        System.out.println(smallest(num));

        int num2 = -691005;
        System.out.println(smallest(num2));
    }
}
