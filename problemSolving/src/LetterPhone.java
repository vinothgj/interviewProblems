import java.util.ArrayList;
import java.util.Arrays;

public class LetterPhone {

    static final String codes[]
            = { "0","1", "abc", "def",
            "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz" };

    public static String[] letterCombinations(String A) {

        return convertArrayListToIntArray(formCombinations(A));

    }

    public static ArrayList<String> formCombinations(String str)
    {
        // If str is empty
        if (str.length() == 0) {
            ArrayList<String> baseRes = new ArrayList<>();
            baseRes.add("");
            return baseRes;
        }

        // First character of str
        char ch = str.charAt(0);

        // Rest of the characters of str
        String restStr = str.substring(1);

        ArrayList<String> prevRes = formCombinations(restStr);
        ArrayList<String> Res = new ArrayList<>();

        String code = codes[ch - '0'];

        for (String val : prevRes) {

            for (int i = 0; i < code.length(); i++) {
                Res.add(code.charAt(i) + val);
            }
        }
        return Res;
    }


    static String[] convertArrayListToIntArray(ArrayList<String> arrayList) {
        String[] result = new String[arrayList.size()];
        int i =0;
        for(String val : arrayList) {
            System.out.println(val);
            result[i] = val;
            i++;
        }
        Arrays.sort(result);
        return result;
    }

    public static void main(String[] args)
    {
        String str = "754";

        // Print all the possible words
        System.out.println(letterCombinations(str));
    }
}
