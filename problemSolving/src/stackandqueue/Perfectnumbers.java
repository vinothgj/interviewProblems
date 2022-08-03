package stackandqueue;

import java.util.ArrayDeque;
import java.util.Queue;

public class Perfectnumbers {
    public String solve(int A) {

        Queue<String> queue = new ArrayDeque<String>();
        String first = "", second = "", ans = "";
        queue.add("11");
        queue.add("22");
        if (A <= 2) {
            while (A > 0) {
                ans = queue.poll();
                A--;
            }
            return ans;
        }

        int b = 3;
        String poll = queue.poll();
        int mid = (poll.length() / 2) - 1;
        int midPlusOne = poll.length() / 2;
        int end = poll.length() - 1;
        first = poll.substring(0, mid + 1);
        second = poll.substring(midPlusOne, end + 1);
        String conn = "";
        while (b <= A) {
            if (b >= 5) {
                if (b % 2 == 1) {
                    poll = queue.poll();
                    mid = (poll.length() / 2) - 1;
                    midPlusOne = poll.length() / 2;
                    end = poll.length() - 1;
                    conn = "11";
                } else {
                    conn = "22";
                }
                first = poll.substring(0, mid + 1);
                second = poll.substring(midPlusOne, end + 1);
                ans = first + conn + second;

            }
            // if the A value at the moment is even or odd
            if (b % 2 == 1) {
                ans = first + "11" + second;
            } else {
                ans = first + "22" + second;
            }
            queue.add(ans);
            b++;
        }
        return ans;
    }

    public static void main(String args[]) {
        System.out.println("11,22,1111,1221,2112,2222,111111,112211,121121,122221");
        Perfectnumbers perfectnumbers = new Perfectnumbers();
        System.out.print(perfectnumbers.solve(1));
        System.out.print(",");
        System.out.print(perfectnumbers.solve(2));
        System.out.print(",");
        System.out.print(perfectnumbers.solve(3));
        System.out.print(",");
        System.out.print(perfectnumbers.solve(4));
        System.out.print(",");
        System.out.print(perfectnumbers.solve(5));
        System.out.print(",");
        System.out.print(perfectnumbers.solve(6));
        System.out.print(",");
        System.out.print(perfectnumbers.solve(7));
        System.out.print(",");
        System.out.print(perfectnumbers.solve(8));
        System.out.print(",");
        System.out.print(perfectnumbers.solve(9));
        System.out.print(",");
        System.out.print(perfectnumbers.solve(10));
        // 11, 22, 1111,1221,2112,2222,111111,112211,221122,222222
    }
}
