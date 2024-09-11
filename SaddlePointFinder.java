public class SaddlePointFinder {

    public static void main(String[] args) {
        int[][] array = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        findSaddlePoint(array);
    }

    public static void findSaddlePoint(int[][] array) {
        int rows = array.length;
        int cols = array[0].length;
        
        for (int i = 0; i < rows; i++) {
            // Find the minimum element in the i-th row and its column index
            int minRowValue = array[i][0];
            int colIndex = 0;
            for (int j = 1; j < cols; j++) {
                if (array[i][j] < minRowValue) {
                    minRowValue = array[i][j];
                    colIndex = j;
                }
            }

            // Check if the found minimum element is the largest in its column
            boolean isSaddlePoint = true;
            for (int k = 0; k < rows; k++) {
                if (array[k][colIndex] > minRowValue) {
                    isSaddlePoint = false;
                    break;
                }
            }

            // If it's a saddle point, print it
            if (isSaddlePoint) {
                System.out.println("Saddle point found at (" + i + ", " + colIndex + ") with value: " + minRowValue);
                return; // Exit after finding the first saddle point
            }
        }

        System.out.println("No saddle point found.");
    }
}