package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RemoveInvalidParanthesis {

    int offSet_left, offSet_right;
    Set<String> result = new HashSet<String>();

    public ArrayList<String> solve(String A) {
        offSet_left = offSet_right = 0;
        setOffsetCounts(A);
        result = new HashSet<String>();
        identifyValidPattern(0, A, "", offSet_left, offSet_right, 0);
        ArrayList<String> ans = new ArrayList<String>();

        for (String s : result) {
            ans.add(s);
        }

        return ans;
    }


    void setOffsetCounts(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ')') {
                if (offSet_left > 0) {
                    offSet_left--;
                } else {
                    offSet_right++;
                }
            } else if (str.charAt(i) == '(') {
                offSet_left++;
            }
        }
    }

    void identifyValidPattern(int index, String str, String curr, int left, int right, int balance) {
        if (index == str.length()) {
            if (left == 0 && right == 0) {
                result.add(curr);
            }
        } else if (balance >= 0) {
            if (str.charAt(index) == '(' && left > 0) {
                identifyValidPattern(index + 1, str, curr, left - 1, right, balance);
            }

            if (str.charAt(index) == ')' && right > 0) {
                identifyValidPattern(index + 1, str, curr, left, right - 1, balance);
            }

            int diff = 0;

            if (str.charAt(index) == '(') {
                diff = 1;
            }
            if (str.charAt(index) == ')') {
                diff = -1;
            }

            identifyValidPattern(index + 1, str, curr + str.charAt(index), left, right, balance + diff);
        }
    }

    public static void main(String arg[]) {
        RemoveInvalidParanthesis removeInvalidParanthesis = new RemoveInvalidParanthesis();
        System.out.println(removeInvalidParanthesis.solve("()())()"));
        System.out.println(removeInvalidParanthesis.solve("(a)())()"));

    }


}
