package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Anagrams {
    int[] freq = new int[26];

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        generateHashFunction();
        Map<Long, ArrayList<Integer>> map = new HashMap<Long, ArrayList<Integer>>();

        for (int i = 0; i < A.size(); i++) {
            Long SUM = 1L;
            char[] arr = A.get(i).toCharArray();

            for (int j = 0; j < arr.length; j++) {
                int fre = arr[j] - 'a';
                SUM += freq[fre];
            }

            if (map.containsKey(SUM)) {
                map.get(SUM).add(i + 1);
            } else {
                ArrayList<Integer> ar1 = new ArrayList<Integer>();
                ar1.add(i + 1);
                map.put(SUM, ar1);
            }

        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

        for (ArrayList<Integer> arrayList : map.values()) {
            ans.add(arrayList);
        }

        return ans;
    }

    void generateHashFunction() {
        int range = 26 * 26;
        Set<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < 26; i++) {
            int val = (int) ((Math.random() * range) * 1L);
            while (set.contains(val)) {
                val = (int) ((Math.random() * range) * 1L);
            }
            freq[i] = val;
            set.add(val);
        }
    }

    public static void main(String arg[]) {
        Anagrams anagrams = new Anagrams();
        System.out.println(anagrams.anagrams(new ArrayList<>(Arrays.asList("cat", "dog", "god", "act"))));
    }
}
