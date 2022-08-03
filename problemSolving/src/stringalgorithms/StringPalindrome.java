package stringalgorithms;

public class StringPalindrome {
    int counter = 0;

    /* Given a string A of size N consisting only of lowercase alphabets. The only operation allowed is to insert characters in the beginning of the string.
    Find and return how many minimum characters are needed to be inserted to make the string a palindrome string.
    Problem Constraints : 1 <= N <= 106
     */
    public int makeStringPalindrome(String A) {
        if (isPalindrome(A, 0, A.length() - 1)) {
            return 0;
        }
        StringBuilder sb = new StringBuilder(A);
        sb.reverse().toString();
        String rev = A;
        rev = rev + "$" + new StringBuilder(rev).reverse().toString();
        int m = rev.length();
        int n = A.length();
        int[] lps = compute_lps(rev.toCharArray(), m);
        return (n - lps[m - 1]);
    }

    /*
    Q2. Closest Palindrome
    Problem Description : Groot has a profound love for palindrome which is why he keeps fooling around with strings.
    A palindrome string is one that reads the same backward as well as forward. Given a string A of size N consisting of lowercase alphabets, he wants to know if it is possible to make the given string a palindrome by changing exactly one of its character.
    Problem Constraints 1 <= N <= 105
    Input Format : First and only argument is a string A.
    Output Format : Return the string YES if it is possible to make the given string a palindrome by changing exactly 1 character. Else, it should return the string NO.
    Example Input
    Input 1:  A = "abbba"
    Input 2:  A = "adaddb"
     */
    public String closestPalindrome(String A) {
        boolean isEven = A.length() % 2 == 0 ? true : false;
        isPalindrome(A, 0, A.length() - 1);
        if (counter > 1) {
            return "NO";
        }

        if (isEven && counter == 1) {
            return "YES";
        }
        return (!isEven && counter <= 1) ? "YES" : "NO";
    }

    boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private int[] compute_lps(char[] arr, int m) {
        int i = 0, j = 1;
        int[] lps = new int[m];
        lps[0] = 0;
        while (j < m) {
            if (arr[i] == arr[j]) {
                i++;
                lps[j] = i;
                j++;
            } else {
                if (i != 0) {
                    i = lps[i - 1];
                } else {
                    lps[j] = 0;
                    j++;
                }
            }
        }
        return lps;
    }

    public static void main(String arg[]) {
        StringPalindrome stringPalindrome = new StringPalindrome();
        System.out.println(stringPalindrome.makeStringPalindrome("abc"));
        System.out.println(stringPalindrome.makeStringPalindrome("bb"));
        System.out.println(stringPalindrome.makeStringPalindrome("bababaa"));
        System.out.println(stringPalindrome.makeStringPalindrome("abababab"));
    }
}
