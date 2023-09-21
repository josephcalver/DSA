package Arrays.Easy;

import java.util.Arrays;

public class NonConstructibleChange {

    public static void main(String[] args) {

        int[] coins = {1, 1, 2, 6};

        int smallestAmountWeCannotMakeInChange = nonConstructibleChange(coins);

        System.out.println(smallestAmountWeCannotMakeInChange);

    }

    // O(n log(n)) time | O(1) space

    public static int nonConstructibleChange(int[] coins) {

        Arrays.sort(coins);

        int runningSum = 0;

        for (int current : coins) {

            if (current - runningSum > 1) return runningSum + 1;

            runningSum += current;

        }

        return runningSum + 1;

    }

}
