package backtracking;

import java.util.ArrayList;
import java.util.HashSet;

public class WordBreak {

    public ArrayList<String> wordBreak(String A, ArrayList<String> B) {
        HashSet<String> dict = new HashSet<>();
        for (String x : B) {
            dict.add(x);
        }
        int n = A.length();
        ArrayList<String> words[] = new ArrayList[A.length() + 1];
        for (int i = 0; i <= n; i++) {
            words[i] = new ArrayList<>();
        }
        words[n].add("");
        for (int i = n - 1; i >= 0; i--) {
            ArrayList<String> values = new ArrayList<>();
            for (int j = i + 1; j <= n; j++) {
                if (dict.contains(A.substring(i, j))) {
                    for (int k = 0; k < words[j].size(); k++) {
                        values.add(A.substring(i, j) + ((words[j].get(k).length() == 0) ? "" : " ") + words[j].get(k));
                    }
                }
            }
            words[i] = values;
        }
        return words[0];
    }
}
