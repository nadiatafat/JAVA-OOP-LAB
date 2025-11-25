public class Main {
    public static void main(String[] args) {

        int size = 3;
        MatrixNaive m1 = new MatrixNaive(size);
        MatrixNaive m2 = new MatrixNaive(size);

        Utils.fillTestValues(m1);
        Utils.fillTestValues(m2);

        int[][] result = m1.multiply(m1, m2);

        Utils.printMatrix("Matrice 1", m1.getMatrix());
        Utils.printMatrix("Matrice 2", m2.getMatrix());
        Utils.printMatrix("Résultat", result);
    }
}
