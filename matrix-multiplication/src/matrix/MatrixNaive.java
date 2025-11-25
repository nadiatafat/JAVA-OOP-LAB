package matrix;

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


		if (m1.size != m2.size)
			throw new IllegalArgumentException("Matrices need to be the same size");

    	int N = m1.size;
        int[][] c = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                c[i][j] = 0;

                for (int k = 0; k < N; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return c;
    }
}
