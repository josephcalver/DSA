package Arrays.Easy;

public class ValidateSubsequence {

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5};
        int[] validSubsequence = {1, 4, 5};
        int[] invalidSubsequence = {1, 5, 4};

        System.out.println(isValidSubsequence(array, validSubsequence));
        System.out.println(isValidSubsequence(array, invalidSubsequence));

    }

//    O(n) time | O(1) space

    public static boolean isValidSubsequence(int[] array, int[] subsequence) {

        int i = 0, j = 0;

        while (i < subsequence.length && j < array.length) {

            if (subsequence[i] == array[j]) i++;

            j++;

        }

        return i == subsequence.length;

    }

}
