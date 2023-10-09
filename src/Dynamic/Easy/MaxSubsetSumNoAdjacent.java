package Dynamic.Easy;

public class MaxSubsetSumNoAdjacent {

    public static void main(String[] args) {

        int[] nums = {75, 105, 120, 75, 90, 135};

        int maxSubsetSum = maxSubsetSumNoAdjacent(nums);

        System.out.println(maxSubsetSum);

    }

//    O(n) time | O(1) space

    public static int maxSubsetSumNoAdjacent(int[] array) {

        if (array.length == 0) {

            return 0;

        } else if (array.length == 1) {

            return array[0];

        }

        int twoPrevious = array[0];
        int onePrevious = Math.max(array[0], array[1]);
        int current = 0;

        for (int i = 2; i < array.length; i++) {

            current = Math.max(onePrevious, array[i] + twoPrevious);

            twoPrevious = onePrevious;
            onePrevious = current;

        }

        return onePrevious;

    }

}
