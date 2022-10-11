package com.geeks.ds.strings;

/**
 * Your task is to implement the function strstr. The function takes two strings as arguments (s,x) and
 * locates the occurrence of the string x in the string s. The function returns and integer denoting
 * the first occurrence of the string x in s (0 based indexing).
 */
public class ImplementStrstr {

    public static void main(String[] args) {

        String s = "GeeksForGeeks";
        String x = "For";

        int res = strstr(s, x);
        if (res == -1) {
            System.out.println("The string x is not present ");
        } else {
            System.out.println("The string x is present at index " + res);
        }

    }

    static int strstr(String X, String Y) {
        if (X == null || Y.length() > X.length()) {
            return -1;
        }
        if (Y == null || Y.length() == 0) {
            return 0;
        }

        for (int i = 0; i <= X.length() - Y.length(); i++) {
            int j;
            for (j = 0; j < Y.length(); j++) {
                if (Y.charAt(j) != X.charAt(i + j)) {
                    break;
                }
            }

            if (j == Y.length()) {
                return i;
            }
        }

        return -1;
    }
}
