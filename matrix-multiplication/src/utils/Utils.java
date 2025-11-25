package utils;

import matrix.MatrixNaive;
import matrix.MatrixOptimized;


public class Utils {

    public static void fillTestValuesNaive(MatrixNaive m) {
        int[][] mat = m.getMatrix();
        int value = 1;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = value++;
            }
        }
    }

	public static void fillTestValuesOptimized(MatrixOptimized m) {
        int[] mat = m.getMatrix();
        int value = 1;
        for (int i = 0; i < mat.length; i++) {
            mat[i] = value++;
        }        
    }

    public static void printMatrixNaive(String name, int[][] matrix) {
        System.out.println("\n" + name + " :");
        for (int[] row : matrix) {
            for (int v : row) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

	public static void printMatrixOptimized(String name, int[] matrix, int N) {
		System.out.println("\n" + name + " :");

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(matrix[i * N + j] + " ");
			}
			System.out.println();
		}
	}

}
