import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FoodPacketDistribution {

    public int solve(int[] A, int B) {

        int minValue = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;

        /*for (int i = 0; i < A.length; i++) {
            minValue = Math.min(minValue,A[i]);
        }*/
        Arrays.sort(A);
        minValue = Math.min(minValue, A[0]);

        System.out.println("Minimum Value : " + minValue);

        for (int i = 0; i < A.length; i++) {
            int val = A[i] % minValue;
            if (val != 0) {
                min = Math.min(minValue, val);
                B = B - ((A[i] / minValue) + 1);
                minValue = Math.min(minValue, min);
            }
            else {
                min = Math.min(minValue, A[i]);
                B = B - (A[i] / minValue);
            }
            System.out.println("Minimum Value : " + minValue);
            //B = B - (A[i] / minValue);
            System.out.println("Remaining Branches : " + B);
        }

        if (B > 0) {
            return 0;
        }
        return min;

    }

    public static void main(String args[]) {
        FoodPacketDistribution foodPacketDistribution = new FoodPacketDistribution();
        //System.out.println(foodPacketDistribution.solve(new int[]{10000, 20000, 30000}, 6));
        //System.out.println(foodPacketDistribution.solve(new int[]{1, 1, 1}, 6));
        //System.out.println(foodPacketDistribution.solve(new int[]{2, 9, 5, 4}, 13));
        //System.out.println(foodPacketDistribution.solve(new int[]{1,4,5}, 13));
        //System.out.println(foodPacketDistribution.solve(new int[]{2,9,5,4}, 13));
        System.out.println(foodPacketDistribution.solve(new int[]{9,8,9}, 4));
    }
}
