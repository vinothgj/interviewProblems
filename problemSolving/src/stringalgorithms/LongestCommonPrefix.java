package stringalgorithms;

import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description : Given the array of strings A, you need to find the longest string S which is the prefix of ALL the strings in the array.
Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.
For Example: longest common prefix of "abcdefgh" and "abcefgh" is "abc".
Problem Constraints
0 <= sum of length of all strings <= 1000000
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(ArrayList<String> A) {

        int len = A.size();
        int minVal = Integer.MAX_VALUE;
        String str = "", prefixStr = "";

        for (int i = 0; i < len; i++) {
            if (A.get(i).length() < minVal) {
                minVal = A.get(i).length();
                str = A.get(i);
            }
        }

        for (int j = 0; j < minVal; j++) {
            boolean isCommon = true;
            for (int k = 0; k < len; k++) {
                if (str.charAt(j) == A.get(k).charAt(j)) {
                    continue;
                } else {
                    isCommon = false;
                    break;
                }
            }
            if (!isCommon) {
                return prefixStr;
            }
            prefixStr += str.charAt(j);
        }

        return prefixStr;

    }

    public static void main(String arg[]) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        ArrayList<String> arrayList = new ArrayList<String>();
        //arrayList.addAll(Arrays.asList("abcdefgh", "aefghijk", "abcefgh"));
        //arrayList.addAll(Arrays.asList("abab", "ab", "abcd"));
        arrayList.addAll(Arrays.asList("cabby", "cabinger", "cable", "cabin", "cat", "cent"));
        System.out.println(longestCommonPrefix.longestCommonPrefix(arrayList));
    }
}
