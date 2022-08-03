package stringalgorithms;

import java.util.ArrayList;
import java.util.Collections;

/*

Problem Description : Given a string A of lowercase English alphabets. Rearrange the characters of the given string A such that there is no boring substring in A.
A boring substring has the following properties:
Its length is 2.
Both the characters are consecutive, for example - "ab", "cd", "dc", "zy" etc.(If the first character is C then the next character can be either (C+1) or (C-1)).
Return 1 if it possible to rearrange the letters of A such that there are no boring substring in A, else return 0.
Problem Constraints
1 <= |A| <= 105
 */
public class BoringSubString {
    public static void main(String arg[]) {
        BoringSubString boringSubString = new BoringSubString();
        /*System.out.println(boringSubString.solve("abcd"));
        System.out.println(boringSubString.solve("aab"));
        System.out.println(boringSubString.solve("abc"));
        System.out.println(boringSubString.solve("gihhfjjejgh"));
        System.out.println(boringSubString.solve("khpptdxfjkkqnxzwqeohcolpfylotgwgyeoqll"));*/
        String src = new String();
        StringBuilder sb = new StringBuilder(src);

        String sr = new String();
        long[] arr = new long[100];

        sr = arr.toString();
        System.out.println("SR " + sr);

        Integer i = 98765;
        sr = i.toString();
        System.out.println("Integer " + sr);


    }

    public int solve(String A) {

        int n = A.length();
        ArrayList<Character> odd = new ArrayList<Character>();
        ArrayList<Character> even = new ArrayList<Character>();

        for (int i = 0; i < n; i++) {
            char atIndex = A.charAt(i);
            if (atIndex % 2 == 0) {
                if (!even.contains(atIndex + "")) {
                    even.add(atIndex);
                }
            } else {
                if (!odd.contains(atIndex + "")) {
                    odd.add(atIndex);
                }
            }
        }
        int oddSize = odd.size();
        int evenSize = even.size();
        Collections.sort(even);
        Collections.sort(odd);

        if (Math.abs(odd.get(oddSize - 1) - even.get(0)) != 1) {
            return 1;
        }
        if (Math.abs(even.get(evenSize - 1) - odd.get(0)) != 1) {
            return 1;
        }

        return 0;
    }
}

