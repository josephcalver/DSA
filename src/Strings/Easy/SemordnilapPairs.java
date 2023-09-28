package Strings.Easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SemordnilapPairs {

    public static void main(String[] args) {

        String[] words = { "abc", "diaper", "cba", "repaid", "java" };

        ArrayList<ArrayList<String>> semordnilapPairs = semordnilap(words);

        System.out.println(semordnilapPairs);

    }

    public static ArrayList<ArrayList<String>> semordnilap(String[] words) {

        Set<String> set = new HashSet<>();

        ArrayList<ArrayList<String>> pairs = new ArrayList<>();

        for (String s : words) {

            String semordnilap = new StringBuilder(s).reverse().toString();

            if (set.contains(semordnilap)) {

                pairs.add(new ArrayList<>(List.of(s, semordnilap)));

            } else {

                set.add(s);

            }

        }

        return pairs;

    }

}
