package Graphs.Medium;

public class SingleCycleCheck {

    public static void main(String[] args) {

        int[] array = {2, 3, 1, -4, -4, 2};

        boolean hasSingleCycle = hasSingleCycle(array);

        System.out.println(hasSingleCycle);

    }

    // O(n) time | O(1) space

    public static boolean hasSingleCycle(int[] array) {

        int jumps = 0, jump = 0, index = 0, len = array.length;

        while (jumps < len) {

            if (array[index] == Integer.MIN_VALUE) return false;

            jump = array[index];

            array[index] = Integer.MIN_VALUE;

            index = (index + jump) % len;

            if (index < 0) index += len;

            jumps++;

        }

        return index == 0;

    }

}
