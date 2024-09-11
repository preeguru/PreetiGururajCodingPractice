public class SubarraySum {
    public static void findSubarrayWithGivenSum(int[] arr, int targetSum) {
        int start = 0, end = 0;
        int currentSum = 0;

        while (end < arr.length) {
            // Add the current element to currentSum
            currentSum += arr[end];

            // While currentSum exceeds the targetSum, subtract elements from the start
            while (currentSum > targetSum && start <= end) {
                currentSum -= arr[start];
                start++;
            }

            // Check if we found the sum
            if (currentSum == targetSum) {
                System.out.println("Subarray found from index " + start + " to " + end);
                return;
            }

            // Move the end pointer forward
            end++;
        }

        // If no subarray found
        System.out.println("No subarray with the given sum found.");
    }

    public static void main(String[] args) {
        int[] arr = {10, 2, -2, -20, 10};
        int targetSum = -10;
        findSubarrayWithGivenSum(arr, targetSum);
    }
}