package Strings.Easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CommonCharacters {

    public static void main(String[] args) {

        String[] strings = {"abc", "edcba", "aaaddbbbbbccdddddeeeeeeeeeeeee"};

        String[] uniqueCommonCharacters = commonCharacters(strings);

        System.out.println(Arrays.toString(uniqueCommonCharacters));

    }

    // O(s x n) time, where s is the # characters in the shortest strings and n is the # strings in the array
    // O(s + 2c) -> O(s + c) space, where s is the # characters in the shortest string, and c is the # unique common characters across all strings

    public static String[] commonCharacters(String[] strings) {

        Set<String> commonCharacters = new HashSet<>();

        String shortest = getShortestString(strings);

        String[] chars = shortest.split("");

        outer:
        for (String current : chars) {

            if (commonCharacters.contains(current)) continue;

            for (String s : strings) {

                if (!s.contains(current)) {

                    continue outer;

                }

            }

            commonCharacters.add(current);

        }

        return commonCharacters.toArray(new String[0]);

    }

    public static String getShortestString(String[] strings) {

        String shortest = strings[0];

        for (String s : strings) {

            if (s.length() < shortest.length()) shortest = s;

        }

        return shortest;

    }

}
