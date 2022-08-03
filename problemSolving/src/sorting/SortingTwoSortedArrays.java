package sorting;

public class SortingTwoSortedArrays {
    public static void main(String[] arg) {
        SortingTwoSortedArrays sortingTwoSortedArrays = new SortingTwoSortedArrays();
        System.out.println(sortingTwoSortedArrays.addBinary("100", "11"));
        System.out.println(sortingTwoSortedArrays.addBinary("1001", "0111"));
        System.out.println(sortingTwoSortedArrays.addBinary("1011", "0111"));
    }

    public String addBinary(String A, String B) {

        int n = A.length(), m = B.length();

        if (n < m) {
            int balance = m - n;
            while (balance > 0) {
                A = '0' + A;
                balance--;
            }
        } else if (m < n) {
            int balance = n - m;
            while (balance > 0) {
                B = '0' + B;
                balance--;
            }
        }

        char carry = '0';
        int len = B.length();
        String[] C = new String[len];

        for (int j = len - 1; j >= 0; j--) {
            char a = A.charAt(j);
            char b = B.charAt(j);

            if (a == b) {
                if (a == '0') {
                    if (carry == '0') {
                        C[j] = "0";
                    } else if (carry == '1') {
                        C[j] = "1";
                    }
                    carry = '0';
                } else if (a == '1') {
                    if (carry == '0') {
                        C[j] = "0";
                    }
                    if (carry == '1') {
                        C[j] = "1";
                    }
                    carry = '1';
                }
            } else {
                if (carry == '0') {
                    C[j] = "1";
                    carry = '0';
                } else {
                    C[j] = "0";
                    carry = '1';
                }
            }
        }
        String ans = "";

        for (int j = len - 1; j >= 0; j--) {
            ans = C[j] + ans;
        }
        if (carry == '1') {
            ans = carry + ans;
        }

        System.out.println(ans);
        return ans;
    }
}

