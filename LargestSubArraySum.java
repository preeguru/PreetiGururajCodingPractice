public class LargestSubArraySum {

    public static void main(String[] args) {
        int[][] array = {
            {1, 2, -1},
            {3, 4, -2},
            {-1, -2, 3}
        };

        int largestSum = findLargestSumOfTwoSubArrays(array);
        System.out.println("The largest sum of any two sub-arrays is: " + largestSum);
    }

    public static int findLargestSumOfTwoSubArrays(int[][] array) {
        int rows = array.length;
        int cols = array[0].length;
        int[] temp = new int[rows];
        int maxSum1 = Integer.MIN_VALUE;
        int maxSum2 = Integer.MIN_VALUE;

        // Iterate over all possible left and right column boundaries
        for (int left = 0; left < cols; left++) {
            // Reset the temporary array
            resetArray(temp);
            for (int right = left; right < cols; right++) {
                // Calculate the row sums for the current column boundary
                for (int i = 0; i < rows; i++) {
                    temp[i] += array[i][right];
                }
                // Find the maximum sub-array sum for the current column boundary
                int currentMax = kadane(temp);

                // Update the two largest sums
                if (currentMax > maxSum1) {
                    maxSum2 = maxSum1;
                    maxSum1 = currentMax;
                } else if (currentMax > maxSum2) {
                    maxSum2 = currentMax;
                }
            }
        }

        return maxSum1 + maxSum2;
    }

    public static int kadane(int[] array) {
        int maxEndingHere = 0;
        int maxSoFar = Integer.MIN_VALUE;
        for (int value : array) {
            maxEndingHere = Math.max(value, maxEndingHere + value);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    public static void resetArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = 0;
        }
    }
}