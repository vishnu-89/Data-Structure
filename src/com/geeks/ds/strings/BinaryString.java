package com.geeks.ds.strings;

/**
 * Given a binary string S. The task is to count the number of substrings that start and end with 1.
 * For example, if the input string is “00100101”, then there are three substrings “1001”, “100101” and “101”.
 */
public class BinaryString {

    public static void main(String[] args) {
        String str = "00100101";
        char st[] = str.toCharArray();
        int n = st.length;
        System.out.println("Total number of sub string " + countSubStr(st, n));
    }

    static int countSubStr(char str[], int n) {
        int m = 0;
        for (int i = 0; i < n; i++) {
            if (str[i] == '1') {
                m++;
            }
        }
        return m * (m - 1) / 2;
    }

    static int countSubStr2(char str[], int n) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (str[i] == '1') {
                for (int j = i + 1; j < n; j++) {
                    if (str[j] == '1')
                        res++;
                }
            }
        }
        return res;
    }
}
