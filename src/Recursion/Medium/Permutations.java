package Recursion.Medium;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {

        List<Integer> array = new ArrayList<>(List.of(1, 2, 3));

        List<List<Integer>> permutations = getPermutationsSuboptimal(array);
        System.out.println(permutations);

        permutations = getPermutationsInPlace(array);
        System.out.println(permutations);

    }

    //    O(n! * n^2) time | O(n! * n) space
    public static List<List<Integer>> getPermutationsSuboptimal(List<Integer> array) {

        List<List<Integer>> permutations = new ArrayList<>();

        getPermutationsSuboptimal(array, new ArrayList<>(), permutations);

        return permutations;

    }

    public static void getPermutationsSuboptimal(List<Integer> array, List<Integer> currentPermutation, List<List<Integer>> permutations) {

        if (array.size() == 0) {

            permutations.add(currentPermutation);

        }

        for (int i = 0; i < array.size(); i++) {

            List<Integer> newArray = new ArrayList<>(array);
            newArray.remove(i);

            List<Integer> newPermutation = new ArrayList<>(currentPermutation);
            newPermutation.add(array.get(i));

            getPermutationsSuboptimal(newArray, newPermutation, permutations);

        }

    }

    //    O(n! * n) time | O(n! * n) space
    public static List<List<Integer>> getPermutationsInPlace(List<Integer> array) {

        List<List<Integer>> permutations = new ArrayList<>();

        getPermutationsInPlace(array, 0, permutations);

        return permutations;

    }

    public static void getPermutationsInPlace(List<Integer> array, int i, List<List<Integer>> permutations) {

        if (i == array.size() - 1) {

            permutations.add(new ArrayList<>(array));

        } else {

            for (int j = i; j < array.size(); j++) {

                swap(array, i, j);

                getPermutationsInPlace(array, i + 1, permutations);

                swap(array, i, j);

            }

        }

    }

    public static void swap(List<Integer> array, int i, int j) {

        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);

    }

}
