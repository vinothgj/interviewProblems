import java.util.HashSet;
import java.util.Set;

public class FindRank {

    public int solve(String A) {
        int size = A.length();
        if (size == 1) {
            return 1;
        }

        int[] fact = new int[size];
        int modInt = 1000003;

        // base case
        fact[0] = 1;
        for (int i = 1; i <= size - 1; i++) {
            fact[i] = ((fact[i - 1] % modInt) * (i % modInt)) % modInt;
        }


        Set<Integer> set = new HashSet<>();
        int sum = 0;
        int k = 0;

        for (int i = size - 1; i >= 0; i--) {
            int asciiValue = A.charAt(i);
            int factValue = fact[k++];
            //System.out.print(factValue + " ");

            //System.out.print(asciiValue + " ");
            if (!set.isEmpty()) {
                int count = (int) set.stream().filter(integer -> integer < asciiValue).count();
                System.out.print(count + " ");
                sum = (sum % modInt + ((count % modInt) * (factValue % modInt)) % modInt) % modInt;
            }
            set.add(asciiValue);
            //System.out.println();
        }
        return sum + 1;
    }

    public static void main(String arg[]) {
        FindRank findRank = new FindRank();
        System.out.println(findRank.solve("BDAC"));
    }


}
