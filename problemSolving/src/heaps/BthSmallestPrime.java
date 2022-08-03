package heaps;

import java.util.HashMap;
import java.util.PriorityQueue;

public class BthSmallestPrime {
        public int[] solve(int[] A, int B) {
            PriorityQueue<Double> min_heap = new PriorityQueue<Double>();
            HashMap<Double, int[]> map = new HashMap<>();
            int n = A.length;

            for(int i=0; i<n-1; i++)
            {
                double fraction = 1D*A[i]/A[n-1];
                min_heap.add(fraction);
                map.put(fraction, new int[]{i, n-1});
            }

            while(B != 1)
            {
                int[] temp = map.remove( min_heap.poll() );
                if( (temp[1]-1) > temp[0])
                {
                    double fraction = 1D*A[temp[0]]/A[temp[1]-1];
                    min_heap.add(fraction);
                    map.put(fraction, new int[]{temp[0], temp[1]-1});
                }
                B--;
            }

            int[] ans = map.get(min_heap.peek());
            return new int[]{A[ans[0]], A[ans[1]]};
        }
}
