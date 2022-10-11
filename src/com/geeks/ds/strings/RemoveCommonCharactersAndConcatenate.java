package com.geeks.ds.strings;

import java.util.HashMap;

/**
 * Given two strings s1 and s2. Modify both the strings such that all the common characters of s1 and s2 are to be removed
 * and the uncommon characters of s1 and s2 are to be concatenated.
 */
public class RemoveCommonCharactersAndConcatenate {

    public static void main(String args[]) {
        String s1 = "abcs";
        String s2 = "cxzca";
        System.out.println(concatenatedString(s1, s2));
    }

    public static String concatenatedString(String s1, String s2) {
        String res = "";
        int i;
        HashMap<Character, Integer> m = new HashMap<Character, Integer>();
        for (i = 0; i < s2.length(); i++) {
            m.put(s2.charAt(i), 1);
        }

        for (i = 0; i < s1.length(); i++) {
            if (!m.containsKey(s1.charAt(i)))
                res += s1.charAt(i);
            else
                m.put(s1.charAt(i), 2);
        }
        for (i = 0; i < s2.length(); i++) {
            if (m.get(s2.charAt(i)) == 1)
                res += s2.charAt(i);
        }
        return res;
    }
}
