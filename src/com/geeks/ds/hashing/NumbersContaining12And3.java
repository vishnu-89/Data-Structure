package com.geeks.ds.hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Given an array of numbers, the task is to print those numbers in ascending order separated by commas which have 1, 2 and 3 in their digits.
 * If no number containing digits 1, 2, and 3 present then print -1.
 */
public class NumbersContaining12And3 {

    public static void main(String[] args) {
        int[] numbers = {123, 1232, 456, 234, 32145};
        System.out.println(checkNumbers(numbers));
    }

    private static String checkNumbers(int[] numbers) {

        ArrayList<Integer> array = new ArrayList<>();
        for (int number : numbers) {

            if (findContainsOneTwoThree(number)) {
                array.add(number);
            }
        }

        Collections.sort(array);

        StringBuffer strbuf = new StringBuffer();
        Iterator it = array.iterator();
        while (it.hasNext()) {

            int value = (int) it.next();
            if (strbuf.length() > 0)
                strbuf.append(", ");

            strbuf.append(Integer.toString(value));
        }

        return (strbuf.length() > 0) ? strbuf.toString() : "-1";
    }

    private static boolean findContainsOneTwoThree(int number) {

        String str = Integer.toString(number);
        return (str.contains("1") && str.contains("2") && str.contains("3"));
    }
}
