import java.util.ArrayList;
import java.util.Stack;

public class GenerateAllParanthesis {

    ArrayList<String> resp;

    public ArrayList<String> generateParenthesis(int A) {
        resp = new ArrayList<String>();
        generateValidParenthesis(new Stack<String>(), 0, 0, A);
        /*System.out.println("Results are here.....");
        for (String str : resp) {
            System.out.println(str + " ");
        }*/
        return resp;
    }

    void generateValidParenthesis(Stack<String> current, int openCounter, int closeCounter, int n) {
        if (openCounter == n && closeCounter == n) {
            resp.add(covertArrayToString(current.toArray()));
            return;
        }

        if (openCounter > n || closeCounter > n) {
            return;
        }

        // case 1 - To add Open bracket
        if (openCounter < n) {

            current.push("(");
            generateValidParenthesis(current, openCounter + 1, closeCounter, n);
            ;
            current.pop();

        }

        // case 2 - To add Close bracket
        if (closeCounter < openCounter) {
            current.push(")");
            generateValidParenthesis(current, openCounter, closeCounter + 1, n);
            current.pop();
        }
    }

    String covertArrayToString(Object[] arr) {
        String res = "";
        for (int i = 0; i < arr.length; i++) {
            res = res + arr[i];
        }
        return res;
    }

    public static void main(String arg[]) {
        GenerateAllParanthesis generateAllParanthesis = new GenerateAllParanthesis();
        System.out.println(generateAllParanthesis.generateParenthesis(3));
        System.out.println(generateAllParanthesis.generateParenthesis(1));
    }


}
