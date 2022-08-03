package linkedlist;

public class ReorderList {
    public ListNode reorderList(ListNode A) {
        ListNode fp = A;
        ListNode sp = A;

        // 1. find the mid point in the list
        while (fp.next != null && fp.next.next != null) {
            sp = sp.next;
            fp = fp.next.next;
        }

        ListNode h1 = A;
        // 2. reverse the second part of the list
        ListNode h2 = reverse(sp.next);
        // 3. break the link between the list
        sp.next = null;

        // 4. merge the alternate elements in the two lists .i.e h1.next -> h2 recursively
        while (h1 != null && h2 != null) {
            ListNode temp = h2.next;
            h2.next = h1.next;
            h1.next = h2;
            h2 = temp;
            h1 = h1.next.next;
        }
        return A;
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

    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        ListNode(int x, ListNode y) {
            val = x;
            next = y;
        }
    }

    public static void main(String args[]) {
        ReorderList reorderList = new ReorderList();
        ListNode B = new ListNode(1, new ListNode(2,
                new ListNode(3, new ListNode(4,
                        new ListNode(5)))));
        System.out.println(reorderList.reorderList(B));

        ListNode A = new ListNode(1, new ListNode(2,
                new ListNode(3, new ListNode(4))));
        System.out.println(reorderList.reorderList(A));
    }
}
