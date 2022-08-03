package hashing;

import java.util.Arrays;

public class PermutationsOfAinB {

    public int solve(String A, String B) {

        int[] arrA = new int[26];

        for (int i = 0; i < A.length(); i++) {
            arrA[A.charAt(i) - 'a']++;
        }

        System.out.println(Arrays.toString(arrA));
        int right = 0, left = 0, counter = 26, ans = 0;
        int[] arrB = new int[26];
        while (right < B.length()) {
            arrB[B.charAt(right) - 'a']++;
            if ((right - left + 1) == A.length()) {
                for (int i = 0; i < 26; i++) {
                    if (arrA[i] == arrB[i]) {
                        continue;
                    } else {
                        counter--;
                    }
                }
                if (counter == 26) {
                    ans++;
                } else {
                    counter = 26;
                }
                arrB[B.charAt(left) - 'a']--;
                left++;
            }
            right++;
        }
        return ans;
    }


    public static void main(String[] args) {
        PermutationsOfAinB permutationsOfAinB = new PermutationsOfAinB();
        //System.out.println(permutationsOfAinB.solve("abc", "abcbacabc"));
        //System.out.println(permutationsOfAinB.solve("aca", "acaa"));
        System.out.println(permutationsOfAinB.solve("bcabaabaacabcabccccabaccabcccacacbbcaabcccaababccccbcaaacbccaaaabbbcbb", "bacbbbacbaabbccaacbbbaabacbcacbbcbcbaacbbbbbbbbcabaacaacbabbaabbcaabcaaacbbacbacbacccbbabaccaaccbbabcabcbccabbcacccbabacccacbbaccccacbbbabbbaccbcacabaabcbaabacbbcbbaabbcbbccbaaccacacabcbbabbabbcabcbbaccbbcabcaccaabacbcbbbcabcabcccacaacbabaaccbbbccacabcbaccbaacbccabaabcabcacacaaabbcbbaaaacbbbbaaccbccbccbbbbccbcaaacbbbcaaabcbaacabbbcabcccaabbcacccccacccbccaaacbbbaaacbcbcaccacbbcaaaaabcaacacbacbbcccacccaabccbbabaabaccbabcbbbbcaccababcccbbbcabcccccccacacaccabbccabacaccbaaaccbcbbccacacabcacbccaacbcacacaaccaabbaabaccbcaababbbcbbababaaabacccabcaaabaaacbbbcabaaabaccbbccbccbcacacbbbcaabbbaacccaabacaaabccbaaaacccabaaacbbabbaabbcaccacbbcbabbbbbbbccacbabababbcccbbcacbbaabcbaabcbbbabbbbabaaacccacabaccabababbbaabacbacbaacbbaaabbcaacbacbaacaacabaccbcccccbcbbcccabcbcbabbabbbcbbccbbabaaaccbbacbacabacbcbabaccaaacbabccbccbaacccbccaaabababbcbaccbaccbbcccbcbcba"));
    }
}