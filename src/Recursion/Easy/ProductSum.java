package Recursion.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductSum {

    public static void main(String[] args) {

        List<Object> nums = new ArrayList<>();

        nums.add(5);
        nums.add(2);
        nums.add(new ArrayList(Arrays.asList(7, -1)));
        nums.add(3);
        nums.add(new ArrayList(Arrays.asList(6, new ArrayList<>(Arrays.asList(-13, 8)), 4)));

        System.out.println(nums);

        int product = productSum(nums, 1);

        System.out.println(product);

    }

    public static int productSum(List<Object> array, int depth) {

        int runningTotal = 0;

        for (Object obj : array) {

            if (obj instanceof Integer) {

                runningTotal += (Integer) obj;

            } else if (obj instanceof ArrayList) {

                runningTotal += productSum((ArrayList) obj, depth + 1);

            }

        }

        return depth * runningTotal;

    }

}
