package com.geeks.ds.strings;

/**
 * Given two strings, we need to check if these strings are Anagram of each other or not.
 */
public class CheckAnagram {

    static final int CHAR = 256;

    public static void main(String args[]) {
        String str1 = "abaac";
        String str2 = "aacba";
        if (areAnagram(str1, str2))
            System.out.println("The two strings are anagram");
        else
            System.out.println("The two strings are not anagram");
    }


    static boolean areAnagram(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }
        int[] count = new int[CHAR];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i)]++;
            count[s2.charAt(i)]--;
        }

        for (int i = 0; i < CHAR; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
