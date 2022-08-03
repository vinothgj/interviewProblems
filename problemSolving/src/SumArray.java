import java.util.ArrayList;

public class SumArray {

    public int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {

        int m = A.length;
        int n = A[m-1].length;
        int[][] auxA = new int[m][n];

        /*for(int i = 0; i<m; i++) {
            for(int j = 0; j <n; j++) {
                System.out.print(A[i][j] + "  | ");
            }
            System.out.println();
        }*/

        for(int j = 0; j<n; j++) {
            auxA[0][j] = A[0][j];
        }

        // column sum
        for(int i = 1; i<m; i++) {
            for(int j = 0; j <n; j++) {
                auxA[i][j] = A[i][j] + auxA[i-1][j];
            }
        }

        // row sum
        for(int i = 0; i<m; i++) {
            for(int j = 1; j <n; j++) {
                auxA[i][j] += auxA[i][j-1];
            }
        }

        //System.out.println("Aux Matrix : ");

       /* for(int i = 0; i<m; i++) {
            for(int j = 0; j <n; j++) {
                System.out.print(auxA[i][j] + "  | ");
            }
            System.out.println("-------------------");
        }
        for(int k = 0; k<B.length;k++) {
            System.out.println("B @ " + k + ": " + B[k]);
            System.out.println("C @ " + k + ": " + C[k]);
            System.out.println("D @ " + k + ": " + D[k]);
            System.out.println("E @ " + k + ": " + E[k]);
        }*/

        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i=0; i<B.length;i++) {
            arrayList.add(sumArray(auxA,B[i]-1,C[i]-1,D[i]-1,E[i]-1));
        }

        return convertArrayListToIntArray(arrayList);

    }

    int[] convertArrayListToIntArray(ArrayList<Integer> arrayList) {
        int[] result = new int[arrayList.size()];
        int i =0;
        for(Integer val : arrayList) {
            result[i] = val;
            i++;
        }
        return result;
    }

    int sumArray(int[][] aux, int a, int b, int c, int d) {

        int sum = aux[c][d];

        if(a>0) {
            sum = sum - aux[a-1][d];
        }


        if(b>0) {
            sum = sum - aux[c][b-1];
        }


        if(a > 0 && b > 0) {
            sum = sum + aux[a-1][b-1];
        }

        return sum;

    }

    public int finPosition(int A) {

        int ans = 0;
        while(A >= 1) {
            A = A/2;
            if(A>1)
            ans = ans * 2;
        }
        return ans;

    }

    public static  void main(String args[]) {
        int mat[][] = {{1, 2, 3, 4, 6},
                {5, 3, 8, 1, 2},
                {4, 6, 7, 5, 5},
                {2, 4, 8, 9, 4}};

        int[] B = new int[] {3,4};
        int[] C = new int[] {3,5};
        int[] D = new int[] {2,4};
        int[] E = new int[] {3,4};

        SumArray sumArray = new SumArray();
        System.out.println(sumArray.solve(mat,B,C,D,E));
    }
}
