package com.geeks.ds.greedy;

/**
 * Geek lost the password of his super locker. He remembers the number of digits N as well as the sum S of all the digits of his password.
 * He know that his password is the largest number of N digits that can be made with given sum S.
 * As he is busy doing his homework, help him retrieving his password.
 */
public class LargestNumberOfGivenSum {

    public static void main (String[] args) {
        int s = 26;
        int m = 3;
        findLargest(m, s);
    }

    static void findLargest(int m, int sum) {
        if (sum == 0) {
            System.out.print(m == 1 ? "Largest number is 0" : "Not possible");
            return ;
        }

        if (sum > 9*m) {
            System.out.println("Not possible");
            return ;
        }
        int[] res = new int[m];

        for (int i = 0; i < m; i++) {
            if (sum >= 9) {
                res[i] = 9;
                sum -= 9;
            }
            else {
                res[i] = sum;
                sum = 0;
            }
        }

        System.out.print("Largest number is ");
        for (int i = 0; i < m; i++) {
            System.out.print(res[i]);
        }
    }

}
