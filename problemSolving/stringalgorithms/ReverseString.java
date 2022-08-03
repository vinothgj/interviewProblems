package stringalgorithms;

/*
Problem Description : Given a string A of size N.
Return the string A after reversing the string word by word.
NOTE:
A sequence of non-space characters constitutes a word.
Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
If there are multiple spaces between words, reduce them to a single space in the reversed string.
Problem Constraints
1 <= N <= 3 * 105
 */
public class ReverseString {

    public String solve(String A) {
        int n = A.length();
        //char[] chars = A.toCharArray();
        String word = "", words = "";
        StringBuilder rev = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            char charAtIndex = A.charAt(i);
            if (charAtIndex == ' ') {
                if (!word.isEmpty()) {
                    rev = new StringBuilder(word).reverse();
                    words += rev;
                    words += " ";
                    word = "";
                    rev = new StringBuilder();
                }
            } else {
                word += charAtIndex;
            }
        }
        if (!word.isEmpty()) {
            rev = new StringBuilder(word).reverse();
            words += rev;
        }
        return words;
    }

    public static void main(String args[]) {
        ReverseString reverseString = new ReverseString();
        System.out.println(reverseString.solve(" This is Vinoth "));
        System.out.println(reverseString.solve("the   sky   is   blue"));
    }
}
