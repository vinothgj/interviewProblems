package stringalgorithms;

public class SentenceReverse {
    public String solve(String A) {

        String[] src = A.split(" ");

        String word = "";

        for (int i = src.length - 1; i >= 0; i--) {
            word += src[i];
            word += " ";
        }

        int num = 4 + 1;
        int num_1 = 5_1;
        //int num_2 = 2200000000;
        String str = "hello" + 4.5;


        return word.trim();
    }

    public String solve(String A, int B) {
        int n = A.length();
        if (B > n) {
            B = B % n;
        }
        String first = A.substring(0, n - B);
        String second = A.substring(n - B);

        System.out.println(first);
        System.out.println(second);
        return second + first;
    }

    public static void main(String arg[]) {
        SentenceReverse sentenceReverse = new SentenceReverse();
        /*System.out.println(sentenceReverse.solve("scaler", 2));
        System.out.println(sentenceReverse.solve("academy", 7));*/
        System.out.println(sentenceReverse.solve("jadgbxjesitcdbnbkftdv", 29));
    }
}
