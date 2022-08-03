package backtracking;

public class PalindromeRecursion {

    boolean solve(String A) {

        return isPalindrome(0, A.length() - 1, A);

    }

    boolean isPalindrome(int a, int b, String str) {
        if (a > b) {
            return true;
        }

        if (str.charAt(a) == str.charAt(b)) {
            return isPalindrome(a + 1, b - 1, str);
        }
        return false;
    }

    public static void main(String args[]) {
        PalindromeRecursion palindromeRecursion = new PalindromeRecursion();
        System.out.println(palindromeRecursion.solve("MALAYALAM"));
        System.out.println(palindromeRecursion.solve("RAYAR"));
    }

}
