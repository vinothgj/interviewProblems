package trees.trie;

import java.util.HashMap;
import java.util.Map;

public class SpellChecker {

    public static void main(String[] arg) {
        SpellChecker spellChecker = new SpellChecker();
        /*System.out.println(spellChecker.solve(new String[]{"hat", "cat", "rat"}, new String[]{"cat", "ball"}));
        System.out.println(spellChecker.solve(new String[]{"tape", "bcci"}, new String[]{"table", "cci"}));*/
        System.out.println(spellChecker.solve(new String[]{"ab", "abc", "abcd", "abcde", "abcdef", "abcdefg"}, new String[]{"a", "b", "ab", "abcd"}));
    }

    public int[] solve(String[] A, String[] B) {
        TrieNode root = new TrieNode();
        int[] ans = new int[B.length];
        int k = 0;
        for (String str : A) {
            insert(root, str);
        }

        for (String b : B) {
            ans[k++] = query(root, b);
        }

        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
        return ans;
    }

    void insert(TrieNode root, String s) {
        TrieNode curr = root;
        for (Character c : s.toCharArray()) {
            if (curr.child == null) {
                curr.child = new HashMap<>();
                curr.child.put(c, new TrieNode());
            } else if (!curr.child.containsKey(c)) {
                curr.child.put(c, new TrieNode());
            }
            curr = curr.child.get(c);
        }
        curr.isEnd = true;
    }

    int query(TrieNode root, String s) {
        TrieNode curr = root;
        for (Character c : s.toCharArray()) {
            if (curr.child.get(c) == null) {
                return 0;
            }
            curr = curr.child.get(c);
        }
        return curr.isEnd ? 1 : 0;
    }

    static class TrieNode {
        Map<Character, TrieNode> child;
        boolean isEnd;
    }
}
