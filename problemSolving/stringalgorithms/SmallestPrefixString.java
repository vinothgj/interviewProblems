package stringalgorithms;

/*
Problem Description : Given 2 strings A and B of size N and M respectively consisting of lowercase alphabets, find the lexicographically smallest string that can be formed by concatenating non empty prefixes of A and B (in that order).
Note: The answer string has to start with a non empty prefix of string A followed by a non empty prefix of string B.
Problem Constraints
1 <= N, M <= 100000
 */
public class SmallestPrefixString {
    public String smallestPrefix(String A, String B) {

        int n = A.length();
        int j = 0;
        String ans = A.charAt(0) + "";
        boolean btrace = false;

        for (int i = 1; i < n; i++) {
            char a = A.charAt(i);
            char b = B.charAt(j);
            if ((a - 'a') < (b - 'a')) {
                ans += a;
            } else {
                ans += b;
                btrace = true;
                break;
            }
        }
        if (!btrace) {
            ans += B.charAt(0);
        }
        return ans;
    }

    public static void main(String arg[]) {
        SmallestPrefixString smallestPrefixString = new SmallestPrefixString();
        System.out.println(smallestPrefixString.smallestPrefix("abc", "ce"));
        System.out.println(smallestPrefixString.smallestPrefix("abba", "cdd"));
        System.out.println(smallestPrefixString.smallestPrefix("acd", "bay"));
    }
}
