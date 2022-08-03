import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Identify2Elements {

    public int[] solve(int[] A) {

        return identify2Elements(A);

    }

    static int[] identify2Elements(int[] a) {

        int res = 0, count = 0, len = a.length;
        Set<Integer> setOnes = new HashSet<>() , setZeros = new HashSet<>();

        for (int i = 0; i < 32; i++) {
            count = 0;
            for (int j = 0; j < len; j++) {
                if ((a[j] & (1 << i)) > 0) {
                    count++;
                }
            }
            if (((count & (count - 1)) == 0) && count > 0) {
                res = i;
                break;
            }
        }

        for (int j = 0; j < len; j++) {
            if (((a[j] >> res) & 1) == 1) {
                if(setOnes.contains(a[j])) {
                    setOnes.remove(a[j]);
                }
                else {
                    setOnes.add(a[j]);
                }

            } else {
                if(setZeros.contains(a[j])) {
                    setZeros.remove(a[j]);
                }
                else {
                    setZeros.add(a[j]);
                }
            }
        }

        int[] resp;
        if (setOnes.size() == 0) {
            resp = convertArrayListToIntArray(setZeros);
        }
        if (setZeros.size() == 0) {
            resp = convertArrayListToIntArray(setOnes);
        }
        setZeros.addAll(setOnes);
        resp = convertArrayListToIntArray(setZeros);
        Arrays.sort(resp);
        return resp;
    }

    static int[] convertArrayListToIntArray(Set<Integer> srcSet) {
        int[] result = new int[srcSet.size()];
        int i = 0;
        for (Integer val : srcSet) {
            result[i] = val;
            i++;
        }
        return result;
    }

    public static void main(String args[]) {
        Identify2Elements identify2Elements = new Identify2Elements();
        //identify2Elements.solve(new int[] {1, 2, 3, 1, 2, 4});
        //identify2Elements.solve(new int[]{186, 256, 102, 377, 186, 377});
        identify2Elements.solve(new int[]{1, 2, 3, 1, 2, 4});
    }

}
