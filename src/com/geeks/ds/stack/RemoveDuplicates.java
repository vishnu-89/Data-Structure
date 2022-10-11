package com.geeks.ds.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * You are given string str. You need to remove the pair of duplicates.
 * Note: The pair should be of adjacent elements and after removing a pair the remaining string is joined together.
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        String str = "azzxzy";
        str = shortenString(str);
        System.out.println("The shorten string : " +str);

    }

    static String shortenString(String str1) {
        Deque<Character> stack = new ArrayDeque<>();

        int i = 0;
        while (i < str1.length()) {
            if (stack.isEmpty() || str1.charAt(i) != stack.peek()) {
                stack.add(str1.charAt(i));
                i++;
            } else {
                stack.pop();
                i++;
            }
        }
        if (stack.isEmpty()) {
            return ("Empty String");
        } else {
            String short_String = "";
            while (!stack.isEmpty()) {
                short_String = stack.peek() +
                        short_String;
                stack.pop();
            }
            return (short_String);
        }
    }

}
