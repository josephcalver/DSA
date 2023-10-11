package Famous.Medium;

public class KadanesAlgorithm {

    public static void main(String[] args) {

        int[] nums = {3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4};

        int maxSubarraySum = kadanesAlgorithm(nums);

        System.out.println(maxSubarraySum);

    }

//    O(n) time | O(1) space

    public static int kadanesAlgorithm(int[] array) {

        int sumToPrevious = 0, maxSum = Integer.MIN_VALUE;

        for (int current : array) {

            sumToPrevious = Math.max(sumToPrevious + current, current);

            maxSum = Math.max(maxSum, sumToPrevious);

        }

        return maxSum;

    }

}
