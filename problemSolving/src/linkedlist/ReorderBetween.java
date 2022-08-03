package linkedlist;

public class ReorderBetween {
    public ListNode reverseBetween(ListNode A, int B, int C) {
        ListNode start = A, head = A, res = new ListNode(0);
        boolean retA = false;
        int counter = 1;

        while (start != null && counter < B) {
            res.next = start;
            res = res.next;
            start = start.next;
            counter++;
        }

        if (res.next != null) {
            retA = true;
        }
        res.next = reverse(start, (C - B));

        return retA ? head : res.next;
    }

    private ListNode reverse(ListNode x, int itemsToReverse) {
        ListNode curr = x, prev = null, nxt = null;
        int revCounter = 0;

        while (curr != null && revCounter < itemsToReverse) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
            revCounter++;
        }

        ListNode temp = curr.next;
        curr.next = prev;
        prev = curr;

        revCounter = 0;
        if (temp == null) {
            x = prev;
        } else {
            while (prev != null && revCounter < itemsToReverse) {
                prev = prev.next;
                revCounter++;
            }
            prev.next = temp;
            x = curr;
        }

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

    public static void main(String args[]) {
        ReorderBetween reorderBetween = new ReorderBetween();
        //ListNode A = new ListNode(1,
        //new ListNode(2, new ListNode(3)));
        //new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode B = new ListNode(97, new ListNode(63,
                new ListNode(89, new ListNode(34,
                        new ListNode(82, new ListNode(95,
                                new ListNode(4, new ListNode(70,
                                        new ListNode(14, new ListNode(41,
                                                new ListNode(38, new ListNode(83,
                                                        new ListNode(49, new ListNode(32,
                                                                new ListNode(68, new ListNode(56,
                                                                        new ListNode(99, new ListNode(52,
                                                                                new ListNode(33, new ListNode(54))))))))))))))))))));
        //System.out.println(reorderBetween.reverseBetween(A, 2, 3));
        System.out.println(reorderBetween.reverseBetween(B, 13, 15));
    }


}
