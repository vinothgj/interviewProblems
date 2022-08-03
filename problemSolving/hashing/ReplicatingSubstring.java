package hashing;

import java.util.HashMap;
import java.util.Map;

public class ReplicatingSubstring {

    public int solve(int A, String B) {

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char[] b = B.toCharArray();

        for (int i = 0; i < b.length; i++) {
            char charAt = b[i];
            if (map.containsKey(b[i])) {
                int val = map.get(charAt);
                map.put(b[i], Integer.valueOf(val + 1));
            } else {
                map.put(b[i], Integer.valueOf(1));
            }
        }

        if (!map.isEmpty()) {
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() % A != 0) {
                    return -1;
                }
            }
        }
        return 1;

    }

    public static void main(String args[]) {
        ReplicatingSubstring replicatingSubstring = new ReplicatingSubstring();
        System.out.println(replicatingSubstring.solve(2, "bbaabb"));
    }

}
