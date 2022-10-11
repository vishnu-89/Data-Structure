package com.geeks.ds.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a number n, write a function that generates and prints all binary numbers with decimal values from 1 to n.
 */
public class GenerateBinaryNumber {

    public static void main(String[] args) {
        int n = 10;
        generatePrintBinary(n);
    }

    static void generatePrintBinary(int n) {
        Queue<String> queue = new LinkedList<String>();
        queue.add("1");
        while (n-- > 0) {
            String s1 = queue.poll();
            System.out.println(s1);
            String s2 = s1;
            queue.add(s1 + "0");
            queue.add(s2 + "1");
        }
    }
}
