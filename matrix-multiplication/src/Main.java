import matrix.MatrixNaive;
import matrix.MatrixOptimized;
import utils.Utils;

public class Main {
    public static void main(String[] args) {
        try {
            int size = 3;

            // Test MatrixNaive
            MatrixNaive mn1 = new MatrixNaive(size);
            MatrixNaive mn2 = new MatrixNaive(size);

            Utils.fillTestValuesNaive(mn1);
            Utils.fillTestValuesNaive(mn2);

            int[][] resultNaive = mn1.multiply(mn1, mn2);

            Utils.printMatrixNaive("Naive Matrice 1", mn1.getMatrix());
            Utils.printMatrixNaive("Naive Matrice 2", mn2.getMatrix());
            Utils.printMatrixNaive("Naive Résultat", resultNaive);

            // Test MatrixOptimized
            MatrixOptimized mo1 = new MatrixOptimized(size);
            MatrixOptimized mo2 = new MatrixOptimized(size);

            Utils.fillTestValuesOptimized(mo1);
            Utils.fillTestValuesOptimized(mo2);

            int[] resultOptimized = mo1.multiply(mo1, mo2);

            Utils.printMatrixOptimized("Optimized Matrice 1", mo1.getMatrix(), size);
            Utils.printMatrixOptimized("Optimized Matrice 2", mo2.getMatrix(), size);
            Utils.printMatrixOptimized("Optimized Résultat", resultOptimized, size);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage() + "\n");
        }
    }
}
