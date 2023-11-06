package Dynamic.Medium;

public class LevenshteinDistance {

    public static void main(String[] args) {

        String str1 = "abc";
        String str2 = "yabd";

        System.out.println(levenshteinDistance(str1, str2));
        System.out.println(levenshteinDistanceOptimisedSpace(str1, str2));

    }

    // O(nm) time | O(nm) space, where n is the length of string 1, m is the length of string 2

    public static int levenshteinDistance(String str1, String str2) {

        int[][] matrix = new int[str1.length() + 1][str2.length() + 1]; // extra index for "" vs ""

        int i = 0;

        while (i < matrix[0].length) matrix[0][i] = i++; // populate top row with 0, 1, 2, 3, etc.

        i = 0;

        while (i < matrix.length) matrix[i][0] = i++; // populate lefthand column with 0, 1, 2, 3, etc.

//        printMatrix(matrix);

        for (int r = 1; r < matrix.length; r++) { // for each row

            for (int c = 1; c < matrix[0].length; c++) { // for each column

                if (str1.charAt(r - 1) == str2.charAt(c - 1)) {

                    matrix[r][c] = matrix[r - 1][c - 1];

                } else {

                    matrix[r][c] = 1 + Math.min(matrix[r][c - 1], Math.min(matrix[r - 1][c - 1], matrix[r - 1][c]));

                }

            }

        }

//        printMatrix(matrix);

        return matrix[str1.length()][str2.length()];

    }


    // O(nm) time | O(min(n, m)) space
    public static int levenshteinDistanceOptimisedSpace(String str1, String str2) {

        String shorter = str1.length() < str2.length() ? str1 : str2;
        String longer = str1.length() >= str2.length() ? str1 : str2;

        int[] evenEdits = new int[shorter.length() + 1]; // + 1 to include row/col for empty string value ""
        int[] oddEdits = new int[shorter.length() + 1];

        for (int i = 0; i < shorter.length() + 1; i++) evenEdits[i] = i; // pre-populate the even/zero/"" row

        int[] currentEdits, previousEdits;

        for (int r = 1; r < longer.length() + 1; r++) {

            if (r % 2 == 0) { // if the current row is even, assign even/odd to current/previous

                previousEdits = oddEdits;
                currentEdits = evenEdits;

            } else {

                previousEdits = evenEdits;
                currentEdits = oddEdits;

            }

            currentEdits[0] = r; // pre-populate the lefthand column with the value of r

            for (int c = 1; c < shorter.length() + 1; c++) {

                if (longer.charAt(r - 1) == shorter.charAt(c - 1)) {

                    currentEdits[c] = previousEdits[c - 1];

                } else {

                    currentEdits[c] = 1 + Math.min(currentEdits[c - 1], Math.min(previousEdits[c - 1], previousEdits[c]));

                }

            }

        }

        return longer.length() % 2 == 0 ? evenEdits[shorter.length()] : oddEdits[shorter.length()];

    }

    public static void printMatrix(int[][] matrix) {

        for (int r = 0; r < matrix.length; r++) {

            for (int c = 0; c < matrix[0].length; c++) {

                System.out.print(matrix[r][c] + " ");

            }

            System.out.println();

        }


    }

}
