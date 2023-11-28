package Sorting.Hard;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] array = {8, 5, 2, 9, 5, 6, 3};

        quickSort(array);

        System.out.println(Arrays.toString(array));

    }

//     O(n^2) worst, O(n log(n)) best time | O(log(n)) space

    public static int[] quickSort(int[] array) {

        quicksort(array, 0, array.length - 1);

        return array;

    }

    public static void quicksort(int[] array, int start, int end) {

        if (start >= end) return; // subarray already sorted

        int pivot = start;
        int left = pivot + 1;
        int right = end;

        while (left <= right) {

            while (left <= right && array[left] <= array[pivot]) left++;

            while (left <= right && array[right] > array[pivot]) right--;

            if (left < right) swap(array, left, right);

        }

        swap(array, pivot, right); // move pivot into final position

        quicksort(array, start, right - 1);
        quicksort(array, right + 1, end);

    }

    public static void swap(int[] array, int i, int j) {

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }

}
