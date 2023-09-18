package Arrays.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TournamentWinner {

    public static void main(String[] args) {

        ArrayList<String> comp1 = new ArrayList<>(List.of("Team A", "Team B"));
        ArrayList<String> comp2 = new ArrayList<>(List.of("Team B", "Team C"));
        ArrayList<String> comp3 = new ArrayList<>(List.of("Team C", "Team A"));

        ArrayList<ArrayList<String>> competitions = new ArrayList<>(List.of(comp1, comp2, comp3));

        ArrayList<Integer> results = new ArrayList<>(List.of(0, 0, 1));

        String winner = tournamentWinner(competitions, results);

        System.out.println(winner);

    }

    public static String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {

        Map<String, Integer> scoreboard = new HashMap<>();

        ArrayList<String> competition;
        String home, away, winningTeam, topTeam = "placeholder";

        scoreboard.put(topTeam, 0);

        for (int i = 0; i < competitions.size(); i++) {

            competition = competitions.get(i);
            home = competition.get(0);
            away = competition.get(1);
            winningTeam = results.get(i) == 1 ? home : away;

            scoreboard.put(winningTeam, scoreboard.getOrDefault(winningTeam, 0) + 3);

            if (scoreboard.get(winningTeam) > scoreboard.get(topTeam)) {

                topTeam = winningTeam;

            }

        }

        return topTeam;

    }

}
