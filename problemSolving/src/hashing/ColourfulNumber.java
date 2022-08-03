package hashing;

import java.util.HashSet;
import java.util.Set;

public class ColourfulNumber {
    public int colorful(int A) {

        int inp = A, len = (A + "").length(), i = len - 1;
        int[] arr = new int[len];
        Set<Integer> set = new HashSet<Integer>();
        while (inp > 0) {
            int modValue = inp % 10;
            arr[i] = modValue;
            i--;
            inp = inp / 10;
        }

        for (int j = 0; j < arr.length; j++) {
            int prod = 1;
            for (int k = j; k < arr.length; k++) {
                prod *= arr[k];
                if (set.contains(prod)) {
                    return 0;
                }
                set.add(prod);

            }
        }

        return 1;
    }

    public static void main(String arg[]) {
        ColourfulNumber colourfulNumber = new ColourfulNumber();
        System.out.println(colourfulNumber.colorful(3245));
        System.out.println(colourfulNumber.colorful(23));
        System.out.println(colourfulNumber.colorful(236));
    }
}

