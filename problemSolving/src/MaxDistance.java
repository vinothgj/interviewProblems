import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class MaxDistance {

    public static void main(String args[]) {
        MaxDistance maxDistance = new MaxDistance();
        System.out.println(maxDistance.solve(new int[]{3, 5, 1, 4, 2}));
    }

    class Points {
        int x;
        int y;
        Points(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int solve(final int[] A) {
        int n = A.length;
        ArrayList<Points> B = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            B.add(new Points(A[i], i + 1));
        }

        Collections.sort(B, new Comparator<Points>() {
            @Override
            public int compare(Points o1, Points o2) {
                return o1.x - o2.x;
            }
        });

        int curr_x = 0, curr_y = 0, prev_x = 0, prev_y = 0;
        int max_y = Integer.MIN_VALUE, resultMax = Integer.MIN_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            Points p = B.get(i);
            curr_x = p.x;
            curr_y = p.y;
            if (i == (n - 1)) {
                prev_x = curr_x;
                prev_y = curr_y;
            } else {
                Points prev = B.get(i + 1);
                prev_x = prev.x;
                prev_x = prev.y;
            }
            max_y = Math.max(max_y, curr_y);
            resultMax = Math.max(resultMax, max_y - curr_y);
        }
        return resultMax;
    }
}
