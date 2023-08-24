package Arrays.Easy;

import java.util.Arrays;

public class SortedSquaredArray {

    public static void main(String[] args) {

        int[] nums = new int[]{-5, -3, 1, 2, 4, 6};

        int[] squares = sortedSquaredArrayBruteForce(nums);

        System.out.println(Arrays.toString(squares));

        squares = sortedSquaredArrayOptimal(nums);

        System.out.println(Arrays.toString(squares));

    }

//    O(n log(n)) time | O(n) space

    public static int[] sortedSquaredArrayBruteForce(int[] array) {

        int[] squares = new int[array.length];

        for (int i = 0; i < array.length; i++) {

            squares[i] = array[i] * array[i];

        }

        Arrays.sort(squares);

        return squares;

    }

//    O(n) time | O(n) space

    public static int[] sortedSquaredArrayOptimal(int[] array) {

        int[] squares = new int[array.length];

        int lastIndex = array.length - 1;

        int left = 0, right = lastIndex, index = lastIndex;

        while (index >= 0) {

            if (Math.abs(array[left]) >= Math.abs(array[right])) {

                squares[index] = array[left] * array[left];

                left++;

            } else {

                squares[index] = array[right] * array[right];

                right--;

            }

            index--;

        }

        return squares;

    }

}
