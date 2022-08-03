package hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestConsecutiveSequence {

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int longestConsecutive(final List<Integer> A) {
        int max = Integer.MIN_VALUE;

        Set<Integer> set = new HashSet<Integer>();

        for (Integer ins : A) {
            set.add(ins);
        }


        for (int i = 0; i < A.size(); i++) {
            Integer element = A.get(i);
            int j = 1;
            if (!set.contains(element - 1)) {
                while (j < A.size()) {
                    if (set.contains(element + j)) {
                        j++;
                    } else {
                        break;
                    }
                }
                max = Math.max(max, j);
            }
        }
        return max;
    }

    public static void main(String args[]) {
        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
        System.out.println(longestConsecutiveSequence.longestConsecutive(Arrays.asList(100, 4, 200, 1, 3, 2)));
        System.out.println(longestConsecutiveSequence.longestConsecutive(Arrays.asList(2, 1)));
    }
}
