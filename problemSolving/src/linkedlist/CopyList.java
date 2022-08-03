package linkedlist;

public class CopyList {
    public RandomListNode copyRandomList(RandomListNode head) {

        RandomListNode h1 = head;

        // step 1 : Insert the copy of each element
        while (h1 != null && h1.next != null) {
            int val = h1.label;
            RandomListNode newNode = new RandomListNode(val);
            newNode.next = h1.next;
            h1.next = newNode;
            h1 = h1.next.next;
        }
        int val1 = h1.label;
        RandomListNode newNode = new RandomListNode(val1);
        h1.next = newNode;

        // step 2 : Assign Random to new nodes
        RandomListNode h2 = head;

        while (h2 != null && h2.next != null) {
            if (h2.random != null) {
                h2.next.random = h2.random.next;
            } else {
                h2.next.random = h2.random;
            }
            h2 = h2.next.next;
        }

        // step 2 : Split original & copy
        RandomListNode h3 = head;
        RandomListNode h4 = head.next;
        RandomListNode h5 = head.next;

        while (h3 != null && h3.next != null && h4 != null && h4.next != null) {
            h3.next = h3.next.next;
            h4.next = h4.next.next;

            h3 = h3.next;
            h4 = h4.next;
        }
        h3.next = null;
        return h5;
    }

    static class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

    public static void main(String args[]) {
        CopyList copyList = new CopyList();
        RandomListNode inp1 = new RandomListNode(83);
        RandomListNode inp2 = new RandomListNode(188);
        RandomListNode inp3 = new RandomListNode(253);
        RandomListNode inp4 = new RandomListNode(281);
        RandomListNode inp5 = new RandomListNode(254);
        RandomListNode inp6 = new RandomListNode(56);
        RandomListNode inp7 = new RandomListNode(70);
        RandomListNode inp8 = new RandomListNode(3);
        RandomListNode inp9 = new RandomListNode(276);
        RandomListNode inp10 = new RandomListNode(233);
        RandomListNode inp11 = new RandomListNode(280);
        RandomListNode inp12 = new RandomListNode(224);
        RandomListNode inp13 = new RandomListNode(16);
        RandomListNode inp14 = new RandomListNode(173);

        inp1.next = inp2;
        inp2.next = inp3;
        inp3.next = inp4;
        inp4.next = inp5;
        inp5.next = inp6;
        inp6.next = inp7;
        inp7.next = inp8;
        inp8.next = inp9;
        inp9.next = inp10;
        inp10.next = inp11;
        inp11.next = inp12;
        inp12.next = inp13;
        inp13.next = inp14;
        inp14.next = null;

        inp1.random = inp3;
        inp2.random = inp13;
        inp3.random = inp14;
        inp4.random = inp4;
        inp5.random = inp3;
        inp6.random = inp3;
        inp7.random = inp14;
        inp8.random = inp5;
        inp9.random = inp3;
        inp10.random = inp3;
        inp11.random = null;
        inp11.random = inp2;
        inp13.random = inp12;
        inp14.random = inp3;


        System.out.println(copyList.copyRandomList(inp1));
    }
}
