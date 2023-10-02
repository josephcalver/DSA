package Searching.Easy;

public class BinarySearch {

    public static void main(String[] args) {

        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println(binarySearch(nums, 3));

        System.out.println(binarySearch(nums, 27));

    }

    public static int binarySearch(int[] array, int target) {

        int start = 0, end = array.length - 1, midIndex = 0, midNum = 0;

        while (start <= end) {

            midIndex = (start + end) / 2;
            midNum = array[midIndex];

            if (target == midNum) {

                return midIndex;

            } else if (target < midNum) {

                end = midIndex - 1;

            } else {

                start = midIndex + 1;

            }

        }

        return -1;

    }

}
