package Strings.Easy;

import java.util.HashMap;
import java.util.Map;

public class GenerateDocument {

    // O(n + m) time, where n is # available characters and m is the # required characters
    // O(c) space, where c is the # unique available characters

    public static void main(String[] args) {

        String characters = "abcabc";

        String document1 = "aabbc";
        String document2 = "aabbcc";
        String document3 = "aabbccc";

        System.out.println(generateDocument(characters, document1));
        System.out.println(generateDocument(characters, document2));
        System.out.println(generateDocument(characters, document3));

    }

    public static boolean generateDocument(String characters, String document) {

        Map<Character, Integer> freq = new HashMap<>();

        for (char c : characters.toCharArray()) {

            freq.put(c, freq.getOrDefault(c, 0) + 1);

        }

        for (char c : document.toCharArray()) {

            freq.put(c, freq.getOrDefault(c, 0) - 1);

            if (freq.get(c) < 0) return false;

        }

        return true;

    }

}
