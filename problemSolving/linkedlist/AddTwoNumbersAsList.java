package linkedlist;

public class AddTwoNumbersAsList {

    public ListNode addTwoNumbers(ListNode A, ListNode B) {

        ListNode h1 = A, h2 = B;
        boolean retA = true;
        int sum = 0, carry = 0, ans = 0, h1count = 0, h2count = 0;
        ListNode temp = null, h3 = null;

        while (h1 != null) {
            h1 = h1.next;
            h1count++;
        }

        while (h2 != null) {
            h2 = h2.next;
            h2count++;
        }

        if (h1count >= h2count) {
            h3 = A;
        } else {
            h3 = B;
            retA = false;
        }

        h1 = A;
        h2 = B;
        while (h1 != null || h2 != null) {
            if (h1 != null) {
                sum = sum + h1.val + carry;
                carry = 0;
            }
            if (h2 != null) {
                sum = sum + h2.val + carry;
            }

            ans = sum % 10;
            carry = sum / 10;

            if (h1 != null) {
                h1 = h1.next;
            }
            if (h2 != null) {
                h2 = h2.next;
            }

            h3.val = ans;
            temp = h3;
            h3 = h3.next;
            sum = 0;
        }

        if (carry > 0) {
            temp.next = new ListNode(carry);
        }

        if (retA) {
            return A;
        }
        return B;
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

    public ListNode partition(ListNode A, int B) {
        ListNode mini = new ListNode(0), max = new ListNode(0), a = mini, b = max;
        ListNode t1 = A;

        while (t1 != null) {
            if (t1.val < B) {
                mini.next = new ListNode(t1.val);
                mini = mini.next;
            } else {
                max.next = new ListNode(t1.val);
                max = max.next;
            }
            t1 = t1.next;
        }
        mini.next = b.next;
        return a.next;
    }

    public ListNode removeLoop(ListNode A) {

        ListNode fp = A;
        ListNode sp = A;

        // step 1. Find fp, sp meeting point
        while (fp.next != null && fp.next.next != null) {
            sp = sp.next;
            fp = fp.next.next;
            if (sp == fp) {
                break;
            }
        }

        // ste 2. Break the loop
        sp = A;

        while (fp.next != sp.next) {
            fp = fp.next;
            sp = sp.next;
        }

        fp.next = null;

        return A;

    }

    public static void main(String[] args) {
        AddTwoNumbersAsList addTwoNumbersAsList = new AddTwoNumbersAsList();

        /*ListNode A = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode B = new ListNode(5, new ListNode(6, new ListNode(4)));

        System.out.println(addTwoNumbersAsList.addTwoNumbers(A, B));*/

        /*ListNode A = new ListNode(9, new ListNode(9, new ListNode(1)));
        ListNode B = new ListNode(1);
        System.out.println(addTwoNumbersAsList.addTwoNumbers(A, B));*/

        /*ListNode A = new ListNode(9, new ListNode(9));
        ListNode B = new ListNode(1);
        System.out.println(addTwoNumbersAsList.addTwoNumbers(A, B));*/


        ListNode C = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2))))));
        System.out.println(addTwoNumbersAsList.partition(C, 3));

        /*ListNode D = new ListNode(18, new ListNode(595, new ListNode(253, new ListNode(7, new ListNode(984, new ListNode(914, new ListNode(903,
                new ListNode(992, new ListNode(522, new ListNode(784, new ListNode(55, new ListNode(910, new ListNode(123, new ListNode(133, new ListNode(936, new ListNode(38, new ListNode(774, new ListNode(868,
                        new ListNode(204, new ListNode(727, new ListNode(927, new ListNode(981, new ListNode(766, new ListNode(619, new ListNode(848, new ListNode(398, new ListNode(782, new ListNode(460, new ListNode(444,
                                new ListNode(805, new ListNode(62, new ListNode(154, new ListNode(35, new ListNode(261, new ListNode(202, new ListNode(622, new ListNode(472, new ListNode(151, new ListNode(590, new ListNode(270,
                                        new ListNode(115, new ListNode(773, new ListNode(332, new ListNode(928, new ListNode(298, new ListNode(597, new ListNode(150, new ListNode(704, new ListNode(229, new ListNode(205, new ListNode(501,
                                                new ListNode(284, new ListNode(497, new ListNode(305, new ListNode(864, new ListNode(368, new ListNode(995, new ListNode(731, new ListNode(255, new ListNode(712, new ListNode(614, new ListNode(179,
                                                        new ListNode(756, new ListNode(432, new ListNode(415, new ListNode(734, new ListNode(449, new ListNode(85, new ListNode(817, new ListNode(686, new ListNode(829, new ListNode(12, new ListNode(564,
                                                                new ListNode(427, new ListNode(711, new ListNode(275, new ListNode(109, new ListNode(641, new ListNode(344, new ListNode(934, new ListNode(760, new ListNode(551, new ListNode(958, new ListNode(540,
                                                                        new ListNode(446)))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))));
        System.out.println(addTwoNumbersAsList.partition(D, 34));*/

        /*ListNode start = new ListNode(3);
        ListNode one = new ListNode(2);
        ListNode two = new ListNode(4);
        ListNode three = new ListNode(5);
        ListNode four = new ListNode(6);


        start.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = two;

        System.out.println(addTwoNumbersAsList.removeLoop(start));*/

    }
}
