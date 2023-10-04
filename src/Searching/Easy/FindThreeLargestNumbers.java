package Searching.Easy;

import java.util.Arrays;

public class FindThreeLargestNumbers {

    public static void main(String[] args) {

        int[] nums = {55, 43, 11, 3, -3, 10};

        int[] top3 = findThreeLargestNumbers(nums);

        System.out.println(Arrays.toString(top3));

    }

    public static int[] findThreeLargestNumbers(int[] array) {

        int[] top3 = new int[3];

        Arrays.fill(top3, Integer.MIN_VALUE);

        for (int current : array) {

            if (current > top3[2]) {

                swap(top3, 2, current);

            } else if (current > top3[1]) {

                swap(top3, 1, current);


            } else if (current > top3[0]) {

                swap(top3, 0, current);

            }

        }

        return top3;

    }

    public static void swap(int[] top3, int index, int current) {

        for (int i = 0; i <= index; i++) {

            if (i == index) {

                top3[i] = current;

            } else {

                top3[i] = top3[i + 1];

            }

        }

    }

}
