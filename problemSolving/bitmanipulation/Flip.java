package bitmanipulation;

import java.util.ArrayList;

public class Flip {

    public int[] flip(String A) {

        int ans = getCountOf1s(A), len = A.length();
        if (len == ans) {
            return new int[]{};
        }
        int sum = 0, start = 0, end = 0;
        int[] prefixSum = new int[len];
        int maxVal = Integer.MIN_VALUE;

        for (int i = 0; i < len; i++) {
            char charAtIndex = A.charAt(i);
            if (charAtIndex == '0') {
                sum = sum + 1;
            } else if (charAtIndex == '1') {
                if (i == 0) {
                    sum = 0;
                } else {
                    sum = sum - 1;
                }
            }
            maxVal = Math.max(maxVal, sum);
            prefixSum[i] = sum;
        }

        ArrayList<Integer> arrayList = convertArrayListToIntArray(prefixSum);
        if(arrayList.get(0) == 0) {
            arrayList.set(0,-1);
        }

       for (int i = 0; i < len; i++) {
            System.out.println("Chat At : " + i + " " + prefixSum[i]);
        }

        end = arrayList.indexOf(maxVal);
        start = end;
        for (int i = end; i >= 0; i--) {
            if (prefixSum[i] == 0 || prefixSum[i] == -1) {
                break;
            }
            start = i;
            System.out.println(start);
        }

        System.out.println("Max value : " + maxVal);
        System.out.println("Start : " + (start + 1));
        System.out.println("End : " + (end + 1));

        return new int[]{start, end + 1};
    }

    ArrayList<Integer> convertArrayListToIntArray(int[] intArray) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int i = 0;
        for (int val : intArray) {
            arrayList.add(val);
        }
        return arrayList;
    }

    int getCountOf1s(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    public static void main(String args[]) {
        Flip flip = new Flip();
        //System.out.println(flip.flip("010"));
        //System.out.println(flip.flip("1101"));
        //System.out.println(flip.flip("100101101"));
        //System.out.println(flip.flip("100101101"));

        //System.out.println(flip.flip("0011101"));
        //System.out.println(flip.flip("01101100010"));
        System.out.println(flip.flip("1101010001"));
    }
}
