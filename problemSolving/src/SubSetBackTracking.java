import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class SubSetBackTracking {
    int size = 0, k = 0;
    ArrayList<Integer> input = null;
    ArrayList<ArrayList<Integer>> result;

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        Collections.sort(A);
        input = A;
        size = A.size();
        result = new ArrayList<ArrayList<Integer>>();

        IdentifySubset(new Stack<>(), -1);

        for (ArrayList<Integer> itr : result) {
            if (itr.iterator().hasNext()) {
                for (Integer itr1 : itr) {
                    System.out.print(itr1 + " ");
                }
                System.out.println();
            }
        }

        return result;
    }

    void IdentifySubset(Stack<Integer> src, int idx) {
        ArrayList<Integer> array = convertArrayListToIntArray(src.toArray());
        result.add(k, array);
        k++;
        if (idx == size) {
            return;
        }
        for (int i = idx + 1; i < size; i++) {
            src.add(input.get(i));
            IdentifySubset(src, i);
            src.pop();
        }
    }

    ArrayList<Integer> convertArrayListToIntArray(Object[] arr) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int i = arr.length - 1; i >= 0; i--) {
            res.add(0, (Integer) arr[i]);
        }
        return res;
    }

    public static void main(String args[]) {
        SubSetBackTracking subSetBackTracking = new SubSetBackTracking();
        ArrayList<Integer> inp = new ArrayList<>();
        //inp.add(11);
        inp.add(12);
        inp.add(13);
        subSetBackTracking.subsets(inp);
    }

}
