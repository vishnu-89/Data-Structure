package com.geeks.ds.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...]
 * find the minimum number of conference rooms required.
 */
public class SchedulingMeetingRooms {

    public static void main(String[] args) {
        int lectures[][] = {
                                { 0, 5 },
                                { 2, 7 },
                                { 6, 8 }
                            };

        System.out.println(minMeetingRooms(lectures));
    }

    public static int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing((int[] itv) -> itv[0]));

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int count = 0;
        for (int[] itv : intervals) {
            if (heap.isEmpty()) {
                count++;
                heap.offer(itv[1]);
            } else {
                if (itv[0] >= heap.peek()) {
                    heap.poll();
                } else {
                    count++;
                }

                heap.offer(itv[1]);
            }
        }

        return count;
    }
}
