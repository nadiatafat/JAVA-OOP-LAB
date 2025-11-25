package matrix;

public class MatrixOptimized {

    private int size;
    private int[] matrix;

    public MatrixOptimized(int size) {
        this.size = size;
        this.matrix = new int[size * size];
    }

    public int[] getMatrix() {
        return this.matrix;
    }

	public int getSize() {
        return this.size;
    }

	private MatrixOptimized transpose(MatrixOptimized m) {
    	int N = m.getSize();
    	MatrixOptimized res = new MatrixOptimized(N);
    	int[] mat = m.getMatrix();
    	int[] resMat = res.getMatrix();

    	for (int i = 0; i < N; i++) {
        	for (int j = 0; j < N; j++) {
            	resMat[j * N + i] = mat[i * N + j];
        	}
    	}
    	return res;
	}


    public int[] multiply(MatrixOptimized m1, MatrixOptimized m2) {

        int[] a = m1.getMatrix();
        int[] b_t = transpose(m2).getMatrix();

		if (m1.size != m2.size)
			throw new IllegalArgumentException("Matrices need to be the same size");

    	int N = m1.size;
        int[] c = new int[N * N];

        for (int i = 0; i < N; i++){
			for (int j = 0; j < N; j++){
				int sum = 0;
                for (int k = 0; k < N; k++) {
                    sum += a[i * N + k] * b_t[j * N + k];
                }
                c[i * N + j] = sum;
            }
        }

        return c;
    }
}
