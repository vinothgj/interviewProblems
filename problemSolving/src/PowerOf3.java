import java.util.ArrayList;

public class PowerOf3 {

    public int[] solve(int A) {

        if(A==1) {
            return new int[] { 1 };
        }

        int ans = 1;
        int sum = A;
        ArrayList<Integer> result = new ArrayList<>();
        result.add(ans);

        while(sum > 0) {
            ans = ans * 3;
            if(sum < ans) {
                ans = ans/3;
                System.out.print(ans + " ");
                result.add(ans);
                sum = sum - ans;
                ans = 1;
            }
        }

        return convertArrayListToIntArray(result);
    }

    int[] convertArrayListToIntArray(ArrayList<Integer> arrayList) {

        System.out.println("****** ");
        int[] result = new int[arrayList.size()];
        int i = arrayList.size()-1;
        for(Integer val : arrayList) {
            result[i] = val;
            i--;
        }

        for(int j = 0; j < arrayList.size()-1;j++) {
            System.out.print(result[j] + " ");
        }
        return result;
    }

    public static void main(String args[]) {

        PowerOf3 powerOf3 = new PowerOf3();
        System.out.println(powerOf3.solve(842));

    }
}
