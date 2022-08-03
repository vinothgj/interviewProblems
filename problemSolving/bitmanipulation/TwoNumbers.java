package bitmanipulation;

public class TwoNumbers {

    public int[] solve(int[] A) {

        int setBits = 0, setGroup = 0, unsetGroup = 0, counter = 0;

        for (int j = 0; j < 31; j++) {
            for (int i = 0; i < A.length; i++) {
                if ((A[i] & (1 << j)) > 0) {
                    setBits++;
                }
            }
            if (setBits % 2 == 1) {
                counter = j;
                break;
            }
        }


        for (int i = 0; i < A.length; i++) {
            if ((A[i] & (1 << counter)) > 0) {
                setGroup = setGroup ^ A[i];
            } else {
                unsetGroup = unsetGroup ^ A[i];
            }
        }

        System.out.println(setGroup);
        System.out.println(unsetGroup);
        return new int[]{setGroup, unsetGroup};

    }

    public static void main(String arg[]) {
        TwoNumbers twoNumbers = new TwoNumbers();
        System.out.println(twoNumbers.solve(new int[]{1, 5, 7, 2, 4, 2, 1, 5}));
    }
}
