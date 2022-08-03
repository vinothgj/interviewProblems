package sorting;

import java.util.Arrays;

public class WaveArray {

    public int[] wave(int[] A) {
        Arrays.sort(A);
        int n = A.length;
        int size = 0;
        if (n % 2 == 0) {
            size = n;
        } else {
            size = n - 1;
        }

        for (int i = 0; i < size; i = i + 2) {

            int temp = A[i + 1];
            A[i + 1] = A[i];
            A[i] = temp;

            //System.out.print(" " + A[i] + " " + A[i + 1]);
        }
        return A;
    }

    public static void main(String arg[]) {
        WaveArray waveArray = new WaveArray();
        System.out.println(waveArray.wave(new int[]{1, 2, 3, 4}));
        System.out.println(waveArray.wave(new int[]{1, 2}));
        System.out.println(waveArray.wave(new int[]{5, 1, 3, 2, 4}));
    }

}
