package stringalgorithms;

public class BobCounter {
    public int solve(String A) {
        int left = 0, right = left + 2, n = A.length();
        int counter = 0;

        for (int i = left; i < n - 2; i++) {
            String temp = A.substring(i, i + 3).toLowerCase();
            System.out.println(temp);
            if (temp.equals("bob")) {
                counter++;
            }
        }

        return counter;

    }

    public static void main(String arg[]) {
        BobCounter bobCounter = new BobCounter();
        System.out.println(bobCounter.solve("aboboc"));
    }
}
