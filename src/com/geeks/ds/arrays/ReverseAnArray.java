package com.geeks.ds.arrays;

public class ReverseAnArray {

    public static void main(String [] args) {
        int [] ar = {4, 10, 20, 40, 100,200};
        int len = ar.length;

        System.out.println("Array before Reversed : ");
        for(int i = 0 ; i < ar.length ; i++) {
            System.out.print(ar[i]+" ");
        }
        reverse(ar, len);
        System.out.println();
        System.out.println("Array after Reversed : ");
        for(int i = 0 ; i < ar.length ; i++) {
            System.out.print(ar[i]+" ");
        }
    }

    private static void reverse(int [] ar , int len) {
        int l = 0 , r = len-1;
        while(l < r) {
            int temp = ar[l];
            ar[l] = ar[r];
            ar[r] = temp;
            l++;
            r--;
        }
    }
}
