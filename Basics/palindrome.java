package Basics;

public class palindrome {
    public static boolean isPalindromeLoop(String s) {
        System.err.println("input is " + s);
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeRec(String s, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }
        return isPalindromeRec(s, left + 1, right - 1);
    }

}
