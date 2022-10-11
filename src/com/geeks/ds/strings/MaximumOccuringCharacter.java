package com.geeks.ds.strings;

/**
 * Given a string str. The task is to find the maximum occurring character in the string str. If more than one character occurs
 * the maximum number of time then print the lexicographically smaller character.
 */
public class MaximumOccuringCharacter {
    public static void main(String args[]) {
        String str = "testsample";
        System.out.println("Index of leftmost repeating character: " + getMaxOccuringCharacter(str));
    }

    private static char getMaxOccuringCharacter(String str) {

        int count[] = new int[256];

        int len = str.length();
        for (int i = 0; i < len; i++) {
            count[str.charAt(i)]++;
        }

        int max = -1;
        char result = ' ';

        for (int i = 0; i < len; i++) {
            if (max < count[str.charAt(i)]) {
                max = count[str.charAt(i)];
                result = str.charAt(i);
            }
        }

        return result;

    }

}
