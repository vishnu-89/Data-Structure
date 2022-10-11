package com.geeks.ds.backtracking;

/**
 * Given a number K and string str of digits denoting a positive integer, build the largest number possible
 * by performing swap operations on the digits of str at most K times.
 */
public class LargestNumberInKswaps {

    static String max;

    public static void main(String args[]) {

        String str = "129814999";
        int k = 4;
        String result = findMaximumNum(str, k);
        System.out.println(result);
    }

    public static String findMaximumNum(String str, int k) {
        max = str;
        findMaximum(str.toCharArray(), k);
        return max;
    }

    public static void findMaximum(char[] strArr, int k) {
        if(k == 0) {
            return;
        }

        for(int i = 0; i < strArr.length - 1; i++) {
            for(int j = i + 1; j < strArr.length; j++) {
                if(strArr[j] > strArr[i]) {
                    strArr = swap(strArr, i, j);
                    String st = new String(strArr);

                    if(max.compareTo(st) < 0) {
                        max = st;
                    }
                    findMaximum(strArr, k - 1);
                    strArr = swap(strArr, i, j);
                }
            }
        }
    }

    public static char[] swap(char[] strArr, int i, int j) {
        char temp = strArr[i];
        strArr[i] = strArr[j];
        strArr[j] = temp;
        return strArr;
    }
}
