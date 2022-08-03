package dynamicprogramming.graph;

import java.util.ArrayList;

public class CaptureRegion {
    public static void main(String arg[]) {
        ArrayList<Character> arr = new ArrayList<Character>();
        ArrayList<ArrayList<Character>> inp = new ArrayList<ArrayList<Character>>();

        //arr.add('X');
        //arr.add('X');
        arr.add('X');
        arr.add('O');
        arr.add('X');
        inp.add(arr);

        arr = new ArrayList<Character>();
        arr.add('X');
        arr.add('O');
        //arr.add('O');
        arr.add('X');
        inp.add(arr);

        arr = new ArrayList<Character>();
        //arr.add('X');
        arr.add('X');
        arr.add('O');
        arr.add('X');
        inp.add(arr);

        /*arr = new ArrayList<Character>();
        arr.add('X');
        arr.add('O');
        arr.add('X');
        arr.add('X');
        inp.add(arr);*/


        CaptureRegion captureRegion = new CaptureRegion();
        captureRegion.solve(inp);
    }

    public void solve(ArrayList<ArrayList<Character>> a) {

        int n = a.size() - 1;
        int m = a.get(0).size() - 1;
        for (int i = 0; i < n; i++) {
            if (a.get(i).get(0) == 'O') {
                a.get(i).set(0, 'P');
            }
            if (a.get(i).get(m) == 'O') {
                a.get(i).set(m, 'P');
            }
        }

        for (int j = 0; j < a.get(0).size(); j++) {
            if (a.get(0).get(j) == 'O') {
                a.get(0).set(j, 'P');
            }
            if (a.get(n).get(j) == 'O') {
                a.get(n).set(j, 'P');
            }
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (a.get(i).get(j) == 'O') {
                    a.get(i).set(j, 'X');
                }
                if (a.get(i).get(j) == 'P') {
                    a.get(i).set(j, 'O');
                }

                System.out.print(a.get(i).get(j));
                System.out.print(" ");
            }
            System.out.println();
        }


    }
}
