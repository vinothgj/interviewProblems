package linkedlist;

public class PalindromeList {
    public int lPalin(ListNode A) {
        ListNode fp = A;
        ListNode sp = A;

        // step 1. Find mid element
        while (fp.next != null && fp.next.next != null) {
            sp = sp.next;
            fp = fp.next.next;
        }

        // step 2. Split the list into two
        ListNode h2 = sp.next;
        sp.next = null;
        ListNode h1 = A;

        //step 3. Reverse the second list
        h2 = reverse(h2);

        // step 4. compare element by element if it is ame & equal
        while (h1 != null && h2 != null) {

            if (h1.val == h2.val) {
                h1 = h1.next;
                h2 = h2.next;
            } else {
                return 0;
            }
        }

        if (h1 == null || (h1 != null && h2 == null)) {
            return 1;
        }
        return 0;
    }

    private ListNode reverse(ListNode x) {
        ListNode curr = x;
        ListNode prev = null;
        ListNode nxt = null;
        int count = 0;

        while (curr != null) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }

        x = prev;
        return x;
    }

    //Definition for singly-linked list.
    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        ListNode(int x, ListNode nxt) {
            val = x;
            next = nxt;
        }
    }

    public static void main(String arg[]) {
        PalindromeList palindromeList = new PalindromeList();
        ListNode A = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        System.out.println(palindromeList.lPalin(A));

        ListNode B = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(1, new ListNode(3, new ListNode(2, new ListNode((1))))))));
        System.out.println(palindromeList.lPalin(B));

        ListNode c = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(1, new ListNode(2, new ListNode((1)))))));
        System.out.println(palindromeList.lPalin(c));
    }
}
