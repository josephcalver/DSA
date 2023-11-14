package Greedy.Medium;

public class ValidStartingCity {

    public static void main(String[] args) {

        int[] distances = {5, 25, 15, 10, 15};
        int[] fuel = {1, 2, 1, 0, 3};
        int mpg = 10;

        int validStartingCity = validStartingCityBruteForce(distances, fuel, mpg);
        System.out.println(validStartingCity);

        validStartingCity = validStartingCityOptimal(distances, fuel, mpg);
        System.out.println(validStartingCity);

    }

    // O(n) time | O(1) space

    public static int validStartingCityOptimal(int[] distances, int[] fuel, int mpg) {

        int remainingMiles = 0, minMiles = 0, minCity = 0;

        for (int city = 1; city < distances.length; city++) {

            remainingMiles += fuel[city - 1] * mpg - distances[city - 1];

            if (remainingMiles < minMiles) {

                minMiles = remainingMiles;
                minCity = city;

            }

        }

        return minCity;

    }

    // O(n^2) time, as for each starting city we're going through all the other cities in the circuit
    // O(1) space, as we're only keeping track of a constant # of variables unrelated to the # cities (n)

    public static int validStartingCityBruteForce(int[] distances, int[] fuel, int mpg) {

        int currentCity = 0, currentCityIndex = 0, remainingMiles = 0;

        outer:
        for (int startingCity = 0; startingCity < distances.length; startingCity++) { // for the # of cities

            remainingMiles = 0;

            for (currentCity = startingCity; currentCity < startingCity + distances.length; currentCity++) {

                currentCityIndex = currentCity % distances.length;

                remainingMiles += fuel[currentCityIndex] * mpg - distances[currentCityIndex];

                if (remainingMiles < 0) continue outer;

            }

            if (remainingMiles >= 0) return startingCity;

        }

        return -1; // no valid solution for input

    }

}
