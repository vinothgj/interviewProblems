import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class AccountManager {

    public int[] solve(int A, int B, int[] C) {
        List<Integer> queue = new ArrayList<>();
        int size = C.length;
        int[] D = new int[size];

        for (int i = 0; i < size; i++) {
            while (!queue.isEmpty() && C[i] >= queue.get(0)) {
                queue.remove(0);
            }
            int nextAvailableAt = C[i] + B;

            queue.add(nextAvailableAt);

            int after = A - queue.size();
            if (after > 0) {
                D[i] = after;
            } else {
                D[i] = 0;
            }

            System.out.print(D[i] + " ");
        }
        return D;
    }

    public static void main(String args[]) {
        AccountManager accountManager = new AccountManager();
        accountManager.solve(4, 5, new int[]{0, 1, 6, 11});
        //accountManager.solve(2, 100, new int[]{0, 1, 5});
        //accountManager.solve(10, 10, new int[]{3, 8, 11, 15, 20 });
    }
}
