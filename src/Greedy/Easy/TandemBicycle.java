package Greedy.Easy;

import java.util.Arrays;

public class TandemBicycle {

    public static void main(String[] args) {

        int[] redShirtSpeeds = {5, 5, 3, 9, 2};
        int[] blueShirtSpeeds = {3, 6, 7, 2, 1};

        int fastestCollectiveSpeed = tandemBicycle(redShirtSpeeds, blueShirtSpeeds, true);
        int slowestCollectiveSpeed = tandemBicycle(redShirtSpeeds, blueShirtSpeeds, false);

        System.out.println(fastestCollectiveSpeed);
        System.out.println(slowestCollectiveSpeed);

    }

//    O(n log(n)) time | O(1) space

    public static int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {

        if (fastest) {

            redShirtSpeeds = Arrays.stream(redShirtSpeeds)
                    .boxed()
                    .sorted((a, b) -> b.compareTo(a)) // Comparator.reverseOrder()
                    .mapToInt(i -> i)
                    .toArray();

        } else {

            Arrays.sort(redShirtSpeeds);

        }

        Arrays.sort(blueShirtSpeeds);

        int runningTotal = 0;

        for (int i = 0; i < redShirtSpeeds.length; i++) {

            runningTotal += Math.max(blueShirtSpeeds[i], redShirtSpeeds[i]);

        }

        return runningTotal;

    }

}
