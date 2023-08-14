package Strings.Easy;

public class PalindromeCheck {

    public static void main(String[] args) {

        String s = "abcdedcba";

        System.out.println(isPalindrome(s));

    }

//    O(n) time | O(1) space

    public static boolean isPalindrome(String s) {

        int left = 0, right = s.length() - 1;

        while (left < right) {

            if (s.charAt(left++) != s.charAt(right--)) return false;
        }

        return true;

    }

}
