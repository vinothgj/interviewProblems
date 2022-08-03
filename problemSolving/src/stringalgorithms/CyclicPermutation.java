package stringalgorithms;

/*
Problem Description : Given two binary strings A and B, count how many cyclic permutations of B when taken XOR with A give 0.
NOTE: If there is a string, S0, S1, ... Sn-1 , then it's cyclic permutation is of the form Sk, Sk+1, ... Sn-1, S0, S1, ... Sk-1 where k can be any integer from 0 to N-1.
Problem Constraints
1 ≤ length(A) = length(B) ≤ 105
 */
public class CyclicPermutation {

    public int solve(String A, String B) {
        int n = A.length();
        B += B;
        int count = 0;

        for (int i = 0; i < A.length(); i++) {
            if (B.substring(i, i + n).equals(A)) {
                count++;
            }
        }

        return count;
    }


    public static void main(String args[]) {
        CyclicPermutation cyclicPermutation = new CyclicPermutation();
        System.out.println(cyclicPermutation.solve("1001", "0011"));
        System.out.println(cyclicPermutation.solve("111", "111"));
    }
}

