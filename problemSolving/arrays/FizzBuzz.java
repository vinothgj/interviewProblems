package arrays;

public class FizzBuzz {
    public static void main(String[] arg) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        System.out.println(fizzBuzz.fizzBuzz(5));
    }

    public String[] fizzBuzz(int A) {
        String[] ans = new String[A];

        for (int i = 1; i <= A; i++) {
            if (i % 3 == 0) {
                if (i % 5 == 0) {
                    ans[i - 1] = "FizzBuzz";
                } else {
                    ans[i - 1] = "Fizz";
                }
            } else if (i % 5 == 0) {
                ans[i - 1] = "Buzz";
            } else {
                ans[i - 1] = i + "";
            }
        }

        return ans;
    }

}
