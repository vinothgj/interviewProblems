package stringalgorithms;

import java.util.ArrayList;

public class UpperAndLowerCase {

    public ArrayList<Character> to_lower(ArrayList<Character> A) {

        for (int i = 0; i < A.size(); i++) {
            Character s = A.get(i);
            if (s > 64 && s < 91) {
                int a = ((int) s) + 32;
                A.set(i, (char) a);
            }
        }

        return A;

    }

    public ArrayList<Character> to_upper(ArrayList<Character> A) {

        for (int i = 0; i < A.size(); i++) {
            Character s = A.get(i);
            if (s > 96 && s < 123) {
                int a = ((int) s) - 32;
                A.set(i, (char) a);
            }
        }

        return A;

    }

    public int isAlpha(ArrayList<Character> A) {

        for (int i = 0; i < A.size(); i++) {
            Character s = A.get(i);
            if (!(s > 96 && s < 123) && !(s > 64 && s < 91)) {
                return 0;
            }
        }

        return 1;

    }

    public static void main(String arg[]) {
        UpperAndLowerCase upperAndLowerCase = new UpperAndLowerCase();
        ArrayList<Character> inp = new ArrayList<>();
        inp.add('s');
        inp.add('C');
        inp.add('a');
        inp.add('L');
        inp.add('e');
        inp.add('R');

        inp.add('A');
        inp.add('c');
        inp.add('A');
        inp.add('d');
        inp.add('E');
        inp.add('m');
        inp.add('Y');

        System.out.println(upperAndLowerCase.to_lower(inp));
        System.out.println(upperAndLowerCase.to_upper(inp));

        inp = new ArrayList<>();
        inp.add('s');
        inp.add('C');
        inp.add('a');
        inp.add('L');
        inp.add('e');
        inp.add('R');

        inp.add('#');
        inp.add('2');
        inp.add('0');
        inp.add('2');
        inp.add('E');
        inp.add('0');
        inp.add('Y');

        System.out.println(upperAndLowerCase.to_lower(inp));
        System.out.println(upperAndLowerCase.to_upper(inp));
    }
}
