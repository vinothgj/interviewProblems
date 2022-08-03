package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountSubArrays {

    public int solve(ArrayList<Integer> A) {
        return findSubArrayCount(A);
    }

    int findSubArrayCount(ArrayList<Integer> A) {
        int ans = 0;
        int left = 0, right = 0;
        Map<Integer, Integer> mapper = new HashMap<Integer, Integer>();

        // 3, 5 , 2, 3, 2
        while (right < A.size()) {
            int diff = 0;
            int arrayElement = A.get(right);
            if (!mapper.containsKey(arrayElement)) {
                mapper.put(arrayElement, right);
            } else {
                int index = mapper.get(arrayElement);
                if (index >= left) {
                    left = index;
                    mapper.put(arrayElement, right);
                }
                left++;
                diff = left - index;
            }
            if (diff <= 1) {
                ans += (right - left) + 1;
            } else {
                ans += (right - left) + diff;
            }
            ans %= 1000000007;
            right++;
        }
        return ans;
    }

    public static void main(String args[]) {
        CountSubArrays countSubArrays = new CountSubArrays();
        ArrayList<Integer> inp = new ArrayList<Integer>();
        inp.addAll(Arrays.asList(93, 9, 12, 32, 97, 75, 32, 77, 40, 79, 61, 42, 57, 19, 64, 16, 86, 47, 41, 67, 76, 63, 24, 10, 25, 96, 1, 30, 73, 91, 70, 65, 53, 75, 5, 19, 65, 6, 96, 33, 73, 55, 4, 90, 72, 83, 54, 78, 67, 56, 8, 70, 43, 63));
        //inp.addAll(Arrays.asList(1, 1, 3));
        //inp.addAll(Arrays.asList(2, 1, 2));
        //inp.addAll(Arrays.asList(3, 5 , 2, 3, 2));
        System.out.println(countSubArrays.solve(inp));
        // 93, 9, 12, 32, 97, 75, 32 , new ListNode( R (6),
        // 77, 40, 79, 61, 42, 57, 19, 64, 16, 86, 47, 41, 67, 76,
        // 63, 24, 10, 25, 96, 1, 30, 73, 91, 70, 65, 53, 75 , new ListNode( R (33),
        // 5, 19 -> R (35), 65 -> R (36), 6, 96 -> R (38), 33, 73 -> R (40), 55, 4,
        // 90, 72, 83, 54, 78, 67 -> R (48), 56, 8, 70 -> R (51), 43, 63
    }
}
