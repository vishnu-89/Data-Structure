package com.geeks.ds.strings;

/**
 * Given a string check if it is Pangram or not. A pangram is a sentence containing every letter in the English Alphabet.
 * Examples : The quick brown fox jumps over the lazy dog ” is a Pangram [Contains all the characters from ‘a’ to ‘z’]
 */
public class CheckPanagram {

    public static void main(String[] args) {
        String str = "The quick brown fox jumps over the lazy dog";

        if (checkPangram(str) == true) {
            System.out.print(str + " is a pangram.");
        } else {
            System.out.print(str + " is not a pangram.");
        }

    }

    public static boolean checkPangram(String str) {
        boolean[] mark = new boolean[26];
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z') {
                index = str.charAt(i) - 'A';
            } else if ('a' <= str.charAt(i) && str.charAt(i) <= 'z') {
                index = str.charAt(i) - 'a';
            } else {
                continue;
            }

            mark[index] = true;
        }

        for (int i = 0; i < 26; i++) {
            if (!mark[i]) {
                return false;
            }
        }

        return true;
    }
}
