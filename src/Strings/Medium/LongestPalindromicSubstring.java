package Strings.Medium;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {

        String str = "abaxyzzyxf";

        String longestPalindromicSubstring = longestPalindromicSubstring(str);

        System.out.println(longestPalindromicSubstring);

    }

    // O(n^2) time | O(n) space

    public static String longestPalindromicSubstring(String str) {

        int left = 0, right = 0, currentCount = 0, longestCount = 0;
        int[] overallLongest = new int[] {0, 1};

        for (int i = 1; i < str.length(); i++) {

            int[] odd = getLongestPalindromeFrom(str, i - 1, i + 1);
            int[] even = getLongestPalindromeFrom(str, i - 1, i);

            int[] longest = odd[1] - odd[0] > even[1] - even[0] ? odd : even;

            overallLongest = longest[1] - longest[0] > overallLongest[1] - overallLongest[0] ? longest : overallLongest;

        }

        return str.substring(overallLongest[0], overallLongest[1]);

    }

    public static int[] getLongestPalindromeFrom(String str, int left, int right) {

        while (left >= 0 && right < str.length()) {

            if (str.charAt(left) == str.charAt(right)) {

                left--;
                right++;

            } else {

                break;

            }

        }

        return new int[] {left + 1, right};

    }

}
