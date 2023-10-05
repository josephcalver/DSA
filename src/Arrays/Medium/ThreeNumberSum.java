package Arrays.Medium;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class ThreeNumberSum {

    public static void main(String[] args) {

        int[] nums = {12, 3, 1, 2, -6, 5, -8, 6};

        List<Integer[]> triplets = threeNumberSum(nums, 0);

        System.out.println(triplets.size());
        System.out.println(Arrays.toString(triplets.get(0)));
        System.out.println(Arrays.toString(triplets.get(1)));
        System.out.println(Arrays.toString(triplets.get(2)));

    }

    // O(n^2) time | O(t) space, where t is # triplets in results list

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {

        Arrays.sort(array);

        List<Integer[]> triplets = new ArrayList<>();

        int left, right, sum;

        for (int i = 0; i < array.length - 2; i++) {

            left = i + 1;
            right = array.length - 1;

            while (left < right) {

                sum = array[i] + array[left] + array[right];

                if (sum == targetSum) {

                    triplets.add(new Integer[]{array[i], array[left], array[right]});

                    left++;
                    right--;

                } else if (sum < targetSum) {

                    left++;

                } else {

                    right--;

                }

            }

        }

        return triplets;

    }

}
