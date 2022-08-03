package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class PalindromicPartition {

    ArrayList<ArrayList<String>> result;
    Set<ArrayList<String>> uniqueCheck;

    public ArrayList<ArrayList<String>> partition(String a) {
        uniqueCheck = new HashSet<ArrayList<String>>();
        result = new ArrayList<ArrayList<String>>();
        recursivePalindromicCheck(0, a, new Stack<String>());
        return result;
    }

    void recursivePalindromicCheck(int start, String str, Stack<String> current) {
        if (start == str.length()) {
            ArrayList<String> validate = convertArrayListToIntArray(current.toArray());
            if (uniqueCheck.add(validate)) {
                result.add(validate);
            }
            return;
        }

        for (int j = start; j < str.length(); j++) {
            if (isPalindrome(str, start, j)) {
                current.push(str.substring(start, j + 1));
                recursivePalindromicCheck(j + 1, str, current);
                current.pop();
            }
        }
    }

    boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    static ArrayList<String> convertArrayListToIntArray(Object[] arr) {
        ArrayList<String> res = new ArrayList<String>();
        for (int i = arr.length - 1; i >= 0; i--) {
            res.add(0, (String) arr[i]);
        }
        return res;
    }

    public static void main(String arg[]) {
        PalindromicPartition palindromicPartition = new PalindromicPartition();
        //System.out.println(palindromicPartition.partition("aab"));
        System.out.println(palindromicPartition.partition("abbab"));
    }
}
