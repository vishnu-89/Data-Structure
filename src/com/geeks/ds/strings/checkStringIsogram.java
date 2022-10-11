package com.geeks.ds.strings;

/**
 * Given a string S of lowercase alphabets, check if it is isogram or not. An Isogram is a string in which no letter occurs more than once.
 */
public class checkStringIsogram {

    public static void main(String[] args) {
        String str = "machine";
        String str2 = "computer";

        if (check_isogram(str))
            System.out.println("True");
        else
            System.out.println("False");

    }

    static boolean check_isogram(String str) {

        int length = str.length();
        int mapHash[] = new int[26];
        for (int i = 0; i < length; i++) {

            mapHash[str.charAt(i) - 'a']++;
            if (mapHash[str.charAt(i) - 'a'] > 1) {
                return false;
            }
        }

        return true;
    }

}
