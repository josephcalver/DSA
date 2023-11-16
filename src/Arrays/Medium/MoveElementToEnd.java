package Arrays.Medium;

import java.util.Arrays;

public class MoveElementToEnd {

    public static void main(String[] args) {

        int[] array = {2, 1, 2, 2, 2, 3, 4, 2};

        moveElementToEnd(array, 2);

        System.out.println(Arrays.toString(array));

    }

//    O(n) time | O(1) space

    public static int[] moveElementToEnd(int[] array, int toMove) {

        int left = 0, right = array.length - 1;

        while (left < right) {

            while (array[left] != toMove && left < right) left++;

            while (array[right] == toMove && left < right) right--;

            swap(array, left, right);

        }

        return array;

    }

    public static void swap(int[] array, int left, int right) {

        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;

    }

}
