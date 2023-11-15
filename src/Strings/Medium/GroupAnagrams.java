package Strings.Medium;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static void main(String[] args) {

        List<String> words = List.of("yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp");

        List<List<String>> groupedAnagrams = groupAnagrams(words);

        System.out.println(groupedAnagrams);

    }

    public static List<List<String>> groupAnagrams(List<String> words) {

        Map<String, List<String>> groups = new HashMap<>();

        for (String word : words) {

            String sortedChars = getSortedChars(word);

            if (groups.containsKey(sortedChars)) {

                groups.get(sortedChars).add(word);

            } else {

                groups.put(sortedChars, new ArrayList<>(List.of(word)));

            }

        }

        return new ArrayList<>(groups.values());

    }

    public static String getSortedChars(String word) {

        char[] sorted = word.toCharArray();

        Arrays.sort(sorted);

        return new String(sorted);

    }

}
