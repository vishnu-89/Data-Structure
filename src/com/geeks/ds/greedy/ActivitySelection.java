package com.geeks.ds.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Write a optimal algorithm for an activity selection problem where in startTime and endTime of an activity are given
 * And at a time one can process a single activity
 */
public class ActivitySelection {

    public static void main(String args[]) {
        Activity arr[] = {
                new Activity(12, 25),
                new Activity(10, 20),
                new Activity(20, 30)
        };
        int n = 3;

        System.out.println(maxActivity(arr, n));

    }

    static int maxActivity(Activity arr[], int n) {
        Arrays.sort(arr, new MyActivityComparator());

        int res = 1;
        int prev = 0;

        for(int curr = 1; curr < n; curr++) {

            if(arr[curr].start >= arr[prev].finish) {
                res++;
                prev = curr;
            }
        }

        return res;
    }

}

class Activity {
    int start;
    int finish;

    Activity(int start, int finish)  {
        this.start = start;
        this.finish = finish;
    }
}

class MyActivityComparator implements Comparator<Activity> {

    public int compare(Activity a1, Activity a2) {
        return a1.finish - a2.finish;
    }
}
