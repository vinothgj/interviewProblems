package trees.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ContactFinder {
    public static void main(String arg[]) {
        ContactFinder contactFinder = new ContactFinder();
        ArrayList<Integer> inp1 = new ArrayList<Integer>();
        inp1.add(0);
        inp1.add(0);
        inp1.add(1);
        inp1.add(1);

        ArrayList<String> inp2 = new ArrayList<String>();
        inp2.add("hack");
        inp2.add("hacker");
        inp2.add("hac");
        inp2.add("hak");
        System.out.println(contactFinder.solve(inp1, inp2));

        inp1 = new ArrayList<Integer>();
        inp1.add(0);
        inp1.add(1);

        inp2 = new ArrayList<String>();
        inp2.add("abcde");
        inp2.add("abc");
        System.out.println(contactFinder.solve(inp1, inp2));
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<String> B) {
        int index = 0;
        TrieNode root = new TrieNode();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (Integer a : A) {
            String text = B.get(index);
            if (a == 0) {
                insert(root, text);
            } else {
                ans.add(query(root, text));
            }
            index++;
        }
        return ans;
    }

    int query(TrieNode root, String s) {
        TrieNode curr = root;
        for (Character c : s.toCharArray()) {
            if (curr.child.get(c) == null) {
                return 0;
            }
            curr = curr.child.get(c);
        }
        return curr.counter;
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
