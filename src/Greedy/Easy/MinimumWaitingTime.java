package Greedy.Easy;

import java.util.Arrays;

public class MinimumWaitingTime {

    public static void main(String[] args) {

        int[] queries = {3, 2, 1, 2, 6};

        int result = minimumWaitingTime(queries);

        System.out.println(result);

    }

    public static int minimumWaitingTime(int[] queries) {

        Arrays.sort(queries);

        int totalWaitingTime = 0;

        for (int i = 0; i < queries.length; i++) {

            totalWaitingTime += (queries[i] * (queries.length - 1 - i));

        }

        return totalWaitingTime;

    }

}
