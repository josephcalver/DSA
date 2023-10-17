package Recursion.Easy;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {

        List<Integer> array = new ArrayList<>(List.of(1, 2, 3));

        List<List<Integer>> permutations = getPermutations(array);

        System.out.println(permutations);

    }

//    O(n! * n^2) time | O(n! * n)

    public static List<List<Integer>> getPermutations(List<Integer> array) {

        List<List<Integer>> permutations = new ArrayList<>();

        getPermutations(array, new ArrayList<>(), permutations);

        return permutations;

    }

    public static void getPermutations(List<Integer> array, List<Integer> currentPermutation, List<List<Integer>> permutations) {

        if (array.size() == 0) {

            permutations.add(currentPermutation);

        }

        for (int i = 0; i < array.size(); i++) {

            List<Integer> newArray = new ArrayList<>(array);
            newArray.remove(i);

            List<Integer> newPermutation = new ArrayList<>(currentPermutation);
            newPermutation.add(array.get(i));

            getPermutations(newArray, newPermutation, permutations);

        }

    }

}
