package Famous.Medium;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class StableInternships {

    public static void main(String[] args) {

        int[][] interns = new int[][]{{0, 1, 2}, {1, 0, 2}, {1, 2, 0}};
        int[][] teams = new int[][]{{2, 1, 0}, {1, 2, 0}, {0, 2, 1}};

        int[][] pairings = stableInternships(interns, teams);

        for (int[] pair : pairings) {

            System.out.println(Arrays.toString(pair));

        }

    }

    // O(n^2) time, worst case, if we have to try and match each intern with each of their preferences
    // O(n^2) space, as the internRankingsByTeam map has n team entries in the top level map, each with a map containing n interns/rankings

    public static int[][] stableInternships(int[][] interns, int[][] teams) {

        int[] choiceNums = new int[interns.length];
        Map<Integer, Map<Integer, Integer>> internRankings = getInternRankingsByTeam(interns, teams);
        Map<Integer, Integer> pairings = new HashMap<>();

        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < interns.length; i++) stack.push(i);

        while (!stack.isEmpty()) {

            int intern = stack.pop();
            int choiceNum = choiceNums[intern]++;
            int preferredTeam = interns[intern][choiceNum];

            if (!pairings.containsKey(preferredTeam)) {

                pairings.put(preferredTeam, intern);

            } else {

                int currentMatch = pairings.get(preferredTeam);
                int currentMatchRank = internRankings.get(preferredTeam).get(currentMatch);
                int potentialMatchRank = internRankings.get(preferredTeam).get(intern);
                int winner = currentMatchRank < potentialMatchRank ? currentMatch : intern;
                int loser = currentMatchRank < potentialMatchRank ? intern : currentMatch;

                pairings.put(preferredTeam, winner);
                stack.push(loser);

            }

        }

        return getPairingsArray(pairings);

    }

    public static Map<Integer, Map<Integer, Integer>> getInternRankingsByTeam(int[][] interns, int[][] teams) {

        Map<Integer, Map<Integer, Integer>> internRankings = new HashMap<>();

        for (int i = 0; i < teams.length; i++) {

            int[] currentTeamPrefs = teams[i];

            Map<Integer, Integer> internRanking = new HashMap<>();

            for (int rank = 0; rank < currentTeamPrefs.length; rank++) {

                internRanking.put(currentTeamPrefs[rank], rank);

            }

            internRankings.put(i, internRanking);

        }

        return internRankings;

    }

    public static int[][] getPairingsArray(Map<Integer, Integer> pairings) {

        int[][] pairingsArray = new int[pairings.size()][2];

        int index = 0;

        for (Map.Entry<Integer, Integer> e : pairings.entrySet()) {

            pairingsArray[index][0] = e.getValue();
            pairingsArray[index][1] = e.getKey();

            index++;

        }

        return pairingsArray;

    }

}
