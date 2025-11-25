public class MatrixNaive {

    private int size;
    private int[][] matrix;

    public MatrixNaive(int size) {
        this.size = size;
        this.matrix = new int[size][size];
    }

    public int[][] getMatrix() {
        return this.matrix;
    }

    public int[][] multiply(MatrixNaive m1, MatrixNaive m2) {

        int[][] a = m1.getMatrix();
        int[][] b = m2.getMatrix();

        int[][] c = new int[m1.size][m2.size];

        for (int i = 0; i < m1.size; i++) {
            for (int j = 0; j < m2.size; j++) {
                c[i][j] = 0;

                for (int k = 0; k < m1.size; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return c;
    }
}
