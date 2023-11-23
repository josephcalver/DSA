package Sorting.Easy;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {

        int[] array = {8, 5, 2, 9, 5, 6, 3};

        selectionSort(array);

        System.out.println(Arrays.toString(array));

    }

//    O(n^2) time | O(1) space

    public static int[] selectionSort(int[] array) {

        int minIndex;

        for (int i = 0; i < array.length - 1; i++) {

            minIndex = i;

            for (int j = i + 1; j < array.length; j++) {

                if (array[j] < array[minIndex]) {

                    minIndex = j;

                }

            }

            swap(array, i, minIndex);

        }

        return array;

    }

    public static void swap(int[] array, int x, int y) {

        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;

    }

}
