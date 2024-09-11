public class MatrixMultiplication {

    public static void main(String[] args) {
        int[][] A = {
            {1, 2, 3},
            {4, 5, 6}
        };

        int[][] B = {
            {7, 8},
            {9, 10},
            {11, 12}
        };

        int[][] result = multiplyMatrices(A, B);

        // Print the result
        if (result != null) {
            for (int[] row : result) {
                for (int value : row) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        }
    }

    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int m = A.length;       // Number of rows in A
        int n = A[0].length;    // Number of columns in A
        int p = B[0].length;    // Number of columns in B

        // Ensure that the number of columns in A is equal to the number of rows in B
        if (n != B.length) {
            throw new IllegalArgumentException("Number of columns in A must equal number of rows in B");
        }

        int[][] result = new int[m][p];

        // Perform matrix multiplication
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return result;
    }
}