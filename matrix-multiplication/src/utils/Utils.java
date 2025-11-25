public class Utils {

    public static void fillTestValues(MatrixNaive m) {
        int[][] mat = m.getMatrix();
        int value = 1;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = value++;
            }
        }
    }

    public static void printMatrix(String name, int[][] matrix) {
        System.out.println("\n" + name + " :");
        for (int[] row : matrix) {
            for (int v : row) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }
}
