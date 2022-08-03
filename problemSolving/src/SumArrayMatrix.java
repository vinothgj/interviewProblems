public class SumArrayMatrix {

    int solve(int index, int val) {
        /*Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        int sum = 0;
        int difVal = 0;
        if (index == 1) {
            map.put(1, new ArrayList<>(val));
            if (map.containsKey(2)) {
                ArrayList<Integer> diff = map.get(1);
                difVal = 0;
                for (Integer ints : diff) {
                    difVal = difVal + ints;
                }
            }
        }
        if (index == 2) {
            map.put(2, new ArrayList<>(val));
            if (map.containsKey(1)) {
                ArrayList<Integer> diff = map.get(1);
                difVal = 0;
                for (Integer ints : diff) {
                    difVal = difVal + ints;
                }

            }
        }
        sum = sum - difVal + (4 * val);*/

        // [1,1,11] [2,4,5], [2,1,1] [1,3,8]
        // query 1 - map { {1, 11} }
        // if (map.contains(2) ) -> find diff; sum = sum + (4 * val) - diff;
        // query 2 - map { {1,11} , {2, 5}}
        // if (map.contains(1) ) -> find diff; sum = sum + (4 * val) - diff;
        // query 3 - map { {1,11} , {2, 5}}
        // if (map.contains(1) ) -> find diff; sum = sum + (4 * val) - diff;
        return 0;
    }

}
