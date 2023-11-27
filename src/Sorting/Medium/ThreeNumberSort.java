package Sorting.Medium;

import java.util.Arrays;

public class ThreeNumberSort {

    public static void main(String[] args) {

        int[] array = {1, 0, 0, -1, -1, 0, 1, 1,};
        int[] order = {0, 1, -1};

        System.out.println(Arrays.toString(solution1(array, order)));

        System.out.println(Arrays.toString(solution2(array, order)));

        System.out.println(Arrays.toString(solution3(array, order)));

    }

//    All solutions O(n) time | O(1) space, although the second and third solutions actually make fewer passes of the array

    public static int[] solution1(int[] array, int[] order) {

        int[] counts = getCounts(array, order);

        return sort(array, order, counts);

    }

    public static int[] sort(int[] array, int[] order, int[] counts) {

        for (int i = 0; i < counts[0]; i++) {

            array[i] = order[0];

        }

        for (int i = counts[0]; i < counts[0] + counts[1]; i++) {

            array[i] = order[1];

        }

        for (int i = counts[0] + counts[1]; i < array.length; i++) {

            array[i] = order[2];

        }

        return array;

    }

    public static int[] getCounts(int[] array, int[] order) {

        int[] counts = new int[3];

        for (int num : array) {

            if (num == order[0]) {

                counts[0]++;

            } else if (num == order[1]) {

                counts[1]++;

            } else if (num == order[2]) {

                counts[2]++;

            }

        }

        return counts;

    }

    public static int[] solution2(int[] array, int[] order) {

        int left = 0, right = array.length - 1;

        for (int i = 0; i < array.length; i++) {

            if (array[i] == order[0]) {

                swap(array, i, left);

                left++;

            }

        }

        for (int i = array.length - 1; i >= left; i--) {

            if (array[i] == order[2]) {

                swap(array, i, right);

                right--;

            }

        }

        return array;

    }

    public static int[] solution3(int[] array, int[] order) {

        int first = 0, second = 0, third = array.length - 1;

        while (second <= third) {

            if (array[second] == order[0]) {

                swap(array, first, second);
                first++;
                second++;

            } else if (array[second] == order[1]) {

                second++;

            } else if (array[second] == order[2]) {

                swap(array, second, third);
                third--;

            }

        }

        return array;

    }

    public static void swap(int[] array, int i, int j) {

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }

}
