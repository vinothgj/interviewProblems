package combinatorics;

public class ComputeNCRmodM {

    public int solve(int A, int B, int C) {
        if ((A == B) || (B == 0)) {
            return 1;
        }
        if (B == 1) {
            return A;
        }

        int triangle[][] = pascalTriangle(A, B, C);

        return triangle[A][B];
    }

    static int[][] pascalTriangle(int a, int b, int c) {
        int result[][] = new int[a + 1][b + 1];

        for (int i = 0; i <= a; i++) {
            for (int j = 0; j <= i && j <= b; j++) {
                if (j == 0 || i == j) {
                    result[i][j] = 1;
                } else {
                    result[i][j] = (result[i - 1][j - 1] % c + result[i - 1][j] % c) % c;
                }
                //System.out.print(result[i][j] + "  ");
            }
            //System.out.println();
        }
        return result;
    }

    public static void main(String arg[]) {
        ComputeNCRmodM computeNCRmodM = new ComputeNCRmodM();
        System.out.println(computeNCRmodM.solve(5, 2, 13));
        System.out.println(computeNCRmodM.solve(6, 2, 13));
        System.out.println(computeNCRmodM.solve(16, 16, 53));
        System.out.println(computeNCRmodM.solve(38, 5, 81));
    }

}
