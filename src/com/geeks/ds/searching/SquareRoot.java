package com.geeks.ds.searching;

/**
 * Given an integer, we need to find floor of its square root.
 */
public class SquareRoot {

    public static void main(String args[]) {

        System.out.println("Floor of a square root : " + sqRootFloor(14));

    }

    static int sqRootFloor(int x) {
        int low = 1;
        int high = x;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int square = mid * mid;

            if (square == x) {
                return mid;
            } else if (square > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
                ans = mid;
            }
        }

        return ans;
    }
}
