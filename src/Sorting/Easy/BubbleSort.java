package Sorting.Easy;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        int[] nums = {23, 7, 4, 2, 89, -6, 1, -45};

        bubbleSort(nums);

        System.out.println(Arrays.toString(nums));

    }

    public static void bubbleSort(int[] nums) {

        boolean performedSwap;

        for (int i = 0; i < nums.length - 1; i++) {

            performedSwap = false;

            for (int j = 0; j < nums.length - 1 - i; j++) {

                if (nums[j] > nums[j + 1]) {

                    swap(nums, j, j + 1);

                    performedSwap = true;

                }

            }

            if (!performedSwap) break;

        }

    }

    public static void swap(int[] nums, int x, int y) {

        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;

    }

}
