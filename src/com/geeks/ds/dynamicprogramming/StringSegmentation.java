package com.geeks.ds.dynamicprogramming;

import java.util.HashSet;
import java.util.Set;

/**
 * You are given a dictionary of words and a large input string. You have to find out whether
 * the input string can be completely segmented into the words of a given dictionary.
 */
public class StringSegmentation {

    private static Set<String> dictionary = new HashSet<>();

    public static void main(String[] args) {

        String temp_dictionary[] = {"mobile", "samsung", "sam", "sung",
                "man", "mango", "icecream", "and",
                "go", "i", "like", "ice", "cream"};

        for (String temp : temp_dictionary) {
            dictionary.add(temp);
        }

        System.out.println(wordBreak("ilikesamsung"));
        System.out.println(wordBreak("ilikelikeimangoiii"));
        System.out.println(wordBreak("samsungandmango"));
        System.out.println(wordBreak("samsungandmangok"));

    }

    // Naive solution exponential time complexity
    public static boolean wordBreakNaive(String word) {
        int size = word.length();

        if (size == 0)
            return true;

        for (int i = 1; i <= size; i++) {

            if (dictionary.contains(word.substring(0, i)) &&
                    wordBreak(word.substring(i, size)))
                return true;
        }

        return false;
    }

    static boolean wordBreak(String str) {
        int size = str.length();
        if (size == 0) {
            return true;
        }

        boolean[] wb = new boolean[size + 1];

        for (int i = 1; i <= size; i++) {
            if (wb[i] == false && dictionaryContains(str.substring(0, i))) {
                wb[i] = true;
            }

            if (wb[i] == true) {
                if (i == size) {
                    return true;
                }

                for (int j = i + 1; j <= size; j++) {

                    if (wb[j] == false && dictionaryContains(str.substring(i, j))) {
                        wb[j] = true;
                    }
                    if (j == size && wb[j] == true) {
                        return true;
                    }

                }
            }
        }

        return false;
    }

    static boolean dictionaryContains(String word) {

        if (dictionary.contains(word)) {
            return true;
        }
        return false;
    }
}
