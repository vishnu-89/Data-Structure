package com.geeks.ds.arrays;

public class LeadersInArray {

    public static void main(String [] args) {
        int [] ar = {16, 17, 4, 3, 5, 2};
        int len = ar.length;

        System.out.println("Leaders in array : ");

        leadersInArray(ar, len);

    }

    private static void leadersInArray(int [] ar , int len) {

        int leader = ar[len-1];
        System.out.print(ar[len-1]+" ");

        for(int i = len-2 ; i >= 0 ; i--) {
            if(leader < ar[i]) {
                leader = ar[i];
                System.out.print(ar[i]+" ");
            }

        }
    }

}
