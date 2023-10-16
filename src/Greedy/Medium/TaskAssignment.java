package Greedy.Medium;

import java.util.*;

public class TaskAssignment {

    public static void main(String[] args) {

        int numWorkers = 3;

        ArrayList<Integer> tasks = new ArrayList<>(List.of(1, 3, 5, 3, 1, 4));

        ArrayList<ArrayList<Integer>> assignments = taskAssignment(numWorkers, tasks);

        System.out.println(assignments);

    }

//    O(n log(n)) time | O(w + d) space, where w is the # workers/assignments in the results list and d is the # unique durations in the map

    public static ArrayList<ArrayList<Integer>> taskAssignment(int numWorkers, ArrayList<Integer> tasks) {

        Map<Integer, ArrayList<Integer>> map = getDurationToIndexMap(tasks);

        ArrayList<Integer> sortedTasks = tasks;
        Collections.sort(sortedTasks);

        ArrayList<ArrayList<Integer>> pairs = new ArrayList<>();

        int shortest, shortestIndex, longest, longestIndex;
        ArrayList<Integer> shortestIndices, longestIndices;

        for (int i = 0; i < numWorkers; i++) {

            shortest = sortedTasks.get(i);
            longest = sortedTasks.get(sortedTasks.size() - 1 - i);

            shortestIndices = map.get(shortest);
            longestIndices = map.get(longest);

            shortestIndex = shortestIndices.remove(shortestIndices.size() - 1);
            longestIndex = longestIndices.remove(longestIndices.size() - 1);

            ArrayList<Integer> pair = new ArrayList<>();
            pair.add(shortestIndex);
            pair.add(longestIndex);

            pairs.add(pair);

        }

        return pairs;

    }

    public static Map<Integer, ArrayList<Integer>> getDurationToIndexMap(ArrayList<Integer> tasks) {

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < tasks.size(); i++) {

            int current = tasks.get(i);

            if (map.containsKey(current)) {

                map.get(current).add(i);

            } else {

                ArrayList<Integer> indices = new ArrayList<>();
                indices.add(i);

                map.put(current, indices);

            }

        }

        return map;

    }

}
