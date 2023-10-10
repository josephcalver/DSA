package Dynamic.Medium;

public class NumberOfWaysToMakeChange {

    public static void main(String[] args) {

        int[] denoms = {2, 3, 4, 7};

        int numWays = numberOfWaysToMakeChange(7, denoms);

        System.out.println(numWays);

    }

//    O(nd) time | O(n) space

    public static int numberOfWaysToMakeChange(int n, int[] denoms) {

        int[] ways = new int[n + 1];
        ways[0] = 1;

        for (int denom : denoms) {

            for (int i = denom; i < ways.length; i++) {

                ways[i] += ways[i - denom];

            }

        }

        return ways[n];

    }

}
