package Arrays.Easy;

public class TransposeMatrix {

    public static void main(String[] args) {

        int[][] matrix = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}};

        int[][] transposed = transposeMatrix(matrix);

        for (int y = 0; y < transposed.length; y++) {

            for (int x = 0; x < transposed[0].length; x++) {

                System.out.print(transposed[y][x] + " ");

            }

            System.out.println();

        }

    }

    public static int[][] transposeMatrix(int[][] matrix) {

        int[][] transposed = new int[matrix[0].length][matrix.length];

        for (int y = 0; y < matrix.length; y++) {

            for (int x = 0; x < matrix[0].length; x++) {

                transposed[x][y] = matrix[y][x];

            }

        }

        return transposed;

    }

}
