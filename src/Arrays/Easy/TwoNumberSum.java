package Arrays.Easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoNumberSum {

    public static void main(String[] args) {

        int[] array = {3, 5, -4, 8, 11, 1, -1, 6};

        int target = 10;

        int[] result1 = solution1(array, target);

        System.out.println(Arrays.toString(result1));

        int[] result2 = solution2(array, target);

        System.out.println(Arrays.toString(result2));

        int[] result3 = solution3(array, target);

        System.out.println(Arrays.toString(result3));

    }

    //    O(n^2) time | O(1) space
    public static int[] solution1(int[] array, int target) {

        for (int i = 0; i < array.length - 1; i++) {

            for (int j = i + 1; j < array.length; j++) {

                if (array[i] + array[j] == target) {

                    return new int[]{array[i], array[j]};

                }

            }

        }

        return new int[0];

    }

    //    O(n) time | O(n) space
    public static int[] solution2(int[] array, int target) {

        Set<Integer> diffs = new HashSet<>();

        for (int current : array) {

            if (diffs.contains(target - current)) {

                return new int[]{current, target - current};

            } else {

                diffs.add(current);

            }

        }

        return new int[0];

    }

    //    O(n log(n)) time | O(1) space
    public static int[] solution3(int[] array, int target) {

        Arrays.sort(array);

        int left = 0, right = array.length - 1, sum = 0;

        while (left < right) {

            sum = array[left] + array[right];

            if (sum == target) {

                return new int[]{array[left], array[right]};

            } else if (sum < target) {

                left++;

            } else {

                right--;

            }

        }

        return new int[0];

    }

}
