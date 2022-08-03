package trees.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShortestUniquePrefix {
    public static void main(String[] args) {
        ShortestUniquePrefix shortestUniquePrefix = new ShortestUniquePrefix();
        ArrayList<String> inp = new ArrayList<>();
        inp.add("zebra");
        inp.add("dog");
        inp.add("duck");
        inp.add("dove");

        System.out.println(shortestUniquePrefix.prefix(inp));

        inp = new ArrayList<>();
        inp.add("apple");
        inp.add("ball");
        inp.add("cat");
        inp.add("dove");

        System.out.println(shortestUniquePrefix.prefix(inp));
    }

    public ArrayList<String> prefix(ArrayList<String> A) {
        TrieNode root = new TrieNode();
        ArrayList<String> ans = new ArrayList<String>();
        for (String str : A) {
            insert(root, str);
        }

        for (String str : A) {
            ans.add(tracePrefix(root, str));
        }
        return ans;
    }

    void insert(TrieNode root, String s) {
        TrieNode curr = root;
        for (Character c : s.toCharArray()) {
            if (curr.child == null) {
                curr.child = new HashMap<>();
                TrieNode node = new TrieNode();
                curr.child.put(c, node);
            } else if (!curr.child.containsKey(c)) {
                TrieNode node = new TrieNode();
                curr.child.put(c, node);
            }
            curr = curr.child.get(c);
            curr.counter++;
        }
        curr.isEnd = true;
    }

    String tracePrefix(TrieNode root, String s) {
        TrieNode curr = root;
        String ans = "";
        for (Character c : s.toCharArray()) {
            if (curr.child.get(c) == null) {
                return "";
            }
            curr = curr.child.get(c);
            ans += c;
            if (curr.counter == 1) {
                return ans;
            }
        }
        return ans;
    }

    static class TrieNode {
        Map<Character, TrieNode> child;
        boolean isEnd;
        int counter;

        TrieNode() {
            this.child = new HashMap<>();
            isEnd = false;
            counter = 0;
        }
    }
}
