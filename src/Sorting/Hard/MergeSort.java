package Sorting.Hard;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

        int[] array = {8, 5, 2, 9, 5, 6, 3};

        System.out.println(Arrays.toString(mergeSortSuboptimalSpace(array)));

        System.out.println(Arrays.toString(mergeSortOptimalSpace(array)));

    }

    // O(n log(n)) time | O(n log(n)) space, since for each division of the array (log(n)) we're creating a copy of each half and a temp array to merge back into (2n -> n)

    public static int[] mergeSortSuboptimalSpace(int[] array) {

        if (array.length <= 1) return array;

        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);

        return mergeSortSuboptimalSpace(mergeSortOptimalSpace(left), mergeSortOptimalSpace(right));

    }

    public static int[] mergeSortSuboptimalSpace(int[] left, int[] right) {

        int[] sorted = new int[left.length + right.length];

        int i = 0, l = 0, r = 0;

        while (l < left.length && r < right.length) {

            if (left[l] <= right[r]) {

                sorted[i++] = left[l++];

            } else {

                sorted[i++] = right[r++];

            }

        }

        while (l < left.length) { // merge remaining elements from either side

            sorted[i++] = left[l++];

        }

        while (r < right.length) {

            sorted[i++] = right[r++];

        }

        return sorted;

    }

    // O(n log(n)) time | O(n) space, since we copy back and forth between the main and aux arrays, rather than create copies of each division

    public static int[] mergeSortOptimalSpace(int[] array) {

        if (array.length <= 1) return array;

        int[] aux = Arrays.copyOf(array, array.length);

        mergeSortOptimalSpace(array, aux, 0, array.length - 1);

        return array;

    }

    public static void mergeSortOptimalSpace(int[] main, int[] aux, int start, int end) {

        if (start == end) return; // one element, nothing to sort

        int mid = (start + end) / 2;

        mergeSortOptimalSpace(aux, main, start, mid);
        mergeSortOptimalSpace(aux, main, mid + 1, end);

        doMerge(main, aux, start, mid, end);

    }

    public static void doMerge(int[] main, int[] aux, int start, int mid, int end) {

        int i = start, l = start, r = mid + 1;

        while (l <= mid && r <= end) {

            if (aux[l] <= aux[r]) {

                main[i++] = aux[l++];

            } else {

                main[i++] = aux[r++];

            }

        }

        while (l <= mid) {

            main[i++] = aux[l++];

        }

        while (r <= end) {

            main[i++] = aux[r++];

        }

    }

}
