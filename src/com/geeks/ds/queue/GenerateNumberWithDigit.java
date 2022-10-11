package com.geeks.ds.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a number n, print first n number(in increasing order) such that all these numbers have digits in set {5, 6}
 */
public class GenerateNumberWithDigit {

    public static void main(String args[]) {
        int n = 5;

        printFirstN(n);
    }

    static void printFirstN(int n) {
        Queue<String> queue = new LinkedList<>();

        queue.add("5");
        queue.add("6");

        for (int i = 0; i < n; i++) {
            String curr = queue.poll();

            System.out.print(curr + " ");

            queue.add(curr + "5");
            queue.add(curr + "6");
        }

    }
}
