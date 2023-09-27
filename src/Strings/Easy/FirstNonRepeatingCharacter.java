package Strings.Easy;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {

        String s = "abcdcaf";

        System.out.println(firstNonRepeatingCharacter(s));

    }

    public static int firstNonRepeatingCharacter(String string) {

        Map<Character, Integer> freq = new LinkedHashMap<>();

        for (char c : string.toCharArray()) {

            freq.put(c, freq.getOrDefault(c, 0) + 1);

        }

        for (Map.Entry<Character, Integer> e : freq.entrySet()) {

            if (e.getValue() == 1) return string.indexOf(e.getKey().toString());

        }

        return -1;

    }

}
