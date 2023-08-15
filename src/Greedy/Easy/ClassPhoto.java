package Greedy.Easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClassPhoto {

    public static void main(String[] args) {

        List<Integer> redShirtHeights = Arrays.asList(5, 8, 1, 3, 4);
        List<Integer> blueShirtHeights = Arrays.asList(6, 9, 2, 4, 5);

        System.out.println(isShorterTallerComboPossible(redShirtHeights, blueShirtHeights));

    }

//    O(n log(n)) time | O(1) space

    public static boolean isShorterTallerComboPossible(List<Integer> redShirtHeights, List<Integer> blueShirtHeights) {

        Collections.sort(redShirtHeights);
        Collections.sort(blueShirtHeights);

        List<Integer> frontRow = redShirtHeights.get(0) > blueShirtHeights.get(0) ? blueShirtHeights : redShirtHeights;
        List<Integer> backRow = redShirtHeights.get(0) > blueShirtHeights.get(0) ? redShirtHeights : blueShirtHeights;

        for (int i = 0; i < frontRow.size(); i++) {

            if (frontRow.get(i) >= backRow.get(i)) {

                return false;

            }

        }

        return true;

    }

}
