package Dynamic.Medium;

import java.util.Arrays;

public class MinNumberOfCoinsForChange {

    public static void main(String[] args) {

        int[] denoms = {1, 5, 10};
        int n = 7;

        int minNumberOfCoins = minNumberOfCoinsForChange(denoms, n);

        System.out.println(minNumberOfCoins);

    }

    // O(dn) time, where d is the # denominations and n is the current denomination through the target amount
    // O(n) space, where n is zero through the target amount
    public static int minNumberOfCoinsForChange(int[] denoms, int n) {

        int[] numCoins = new int[n + 1];
        Arrays.fill(numCoins, Integer.MAX_VALUE);
        numCoins[0] = 0; // "base case" for amount - denom when amount == denom (so we get 1 + 0 = 1 on first iteration through amounts)

        for (int denom : denoms) {

            for (int amount = denom; amount < numCoins.length; amount++) {

                // when amount - denom is not zero, and the value at that index == Integer.MAX_VALUE, we cannot make that amount -- so continue
                if (numCoins[amount - denom] == Integer.MAX_VALUE) continue;

                numCoins[amount] = Math.min(numCoins[amount], 1 + numCoins[amount - denom]);

            }

        }

        return numCoins[n] == Integer.MAX_VALUE ? -1 : numCoins[n];

    }

}
