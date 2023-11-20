package Recursion.Medium;

import java.util.ArrayList;
import java.util.List;

public class Powerset {

    public static void main(String[] args) {

        List<Integer> nums = List.of(1, 2, 3);

        List<List<Integer>> powerset = powersetIterative(nums);

        System.out.println(powerset);

        powerset = powersetRecursive(nums);

        System.out.println(powerset);

    }

//    O(2^n * n) time | O(2^n * n) space

    public static List<List<Integer>> powersetIterative(List<Integer> nums) {

        List<List<Integer>> powerset = new ArrayList<>();
        powerset.add(new ArrayList<>());

        for (int n : nums) {

            int subsets = powerset.size();

            for (int i = 0; i < subsets; i++) {

                List<Integer> subset = powerset.get(i);
                List<Integer> clone = new ArrayList<>(subset);
                clone.add(n);
                powerset.add(clone);

            }

        }

        return powerset;

    }

    public static List<List<Integer>> powersetRecursive(List<Integer> nums) {

        return powersetRecursive(nums, nums.size() - 1);

    }

    //    O(2^n * n) time | O(2^n * n) space

    public static List<List<Integer>> powersetRecursive(List<Integer> nums, int index) {

        if (index < 0) {

            List<List<Integer>> powerset = new ArrayList<>();
            powerset.add(new ArrayList<>());

            return powerset;

        }

        int current = nums.get(index);

        List<List<Integer>> powerset = powersetRecursive(nums, index - 1);

        int subsets = powerset.size();

        for (int i = 0; i < subsets; i++) {

            List<Integer> subset = powerset.get(i);
            List<Integer> newSubset = new ArrayList<>(subset);
            newSubset.add(current);
            powerset.add(newSubset);

        }

        return powerset;

    }

}
