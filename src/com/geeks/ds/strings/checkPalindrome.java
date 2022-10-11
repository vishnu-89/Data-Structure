package com.geeks.ds.strings;

/**
 * Given a string check if palindrome
 */
public class checkPalindrome {

    public static void main(String[] args) {
        String s = "madam";
        System.out.print("Is Palindrome :" + isPalindrome(s, s.length()));
    }

    public static boolean isPalindrome(String str, int n) {
        int i = 0;
        int j = str.length() - 1;

        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;

    }
}
