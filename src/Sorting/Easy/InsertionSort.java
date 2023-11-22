package Sorting.Easy;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {

        int[] nums = {8, 5, 2, 9, 5, 6, 3};

        insertionSort(nums);

        System.out.println(Arrays.toString(nums));

    }

//    O(n) best, O(n^2) worst time | O(1) space

    public static int[] insertionSort(int[] array) {

        for (int n = 1; n < array.length; n++) {

            int index = n;

            while (index > 0 && array[index] < array[index - 1]) {

                swap(array, index, index - 1);

                index--;

            }

        }

        return array;

    }

    public static void swap(int[] array, int x, int y) {

        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;

    }

}
