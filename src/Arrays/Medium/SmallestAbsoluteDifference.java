package Arrays.Medium;

import java.util.Arrays;

public class SmallestAbsoluteDifference {

    public static void main(String[] args) {

        int[] arrayOne = {-1, 3, 5, 10, 20, 28};
        int[] arrayTwo = {15, 17, 26, 134, 135};

        int[] smallestPair = smallestAbsoluteDifference(arrayOne, arrayTwo);

        System.out.println(Arrays.toString(smallestPair));

    }

    public static int[] smallestAbsoluteDifference(int[] arrayOne, int[] arrayTwo) {

        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        int indexOne = 0, indexTwo = 0, numOne, numTwo, currentDiff, smallestDiff = Integer.MAX_VALUE;
        int[] smallestPair = new int[2];

        while (indexOne < arrayOne.length && indexTwo < arrayTwo.length) {

            numOne = arrayOne[indexOne];
            numTwo = arrayTwo[indexTwo];

            currentDiff = Math.abs(numOne - numTwo);

            if (currentDiff == 0) return new int[]{numOne, numTwo};

            if (currentDiff < smallestDiff) {

                smallestDiff = currentDiff;
                smallestPair[0] = numOne;
                smallestPair[1] = numTwo;

            }

            if (numOne < numTwo) {

                indexOne++;

            } else {

                indexTwo++;

            }

        }

        return smallestPair;

    }

}
