package com.geeks.ds.arrays;

public class RemoveDuplicateFromSortedArray {

    public static void main(String [] args) {
        int [] ar = {4, 10, 10, 40, 40, 100,200};
        int len = ar.length;

        System.out.println("Array before removing duplicates : ");
        for(int i = 0 ; i < ar.length ; i++) {
            System.out.print(ar[i]+" ");
        }

        int n = removeDuplicates(ar, len);
        System.out.println();

        System.out.println("Array after removing duplicates : ");
        for(int i = 0 ; i < n ; i++) {
            System.out.print(ar[i]+" ");
        }
    }

    private static int removeDuplicates(int [] ar, int len) {
        int index = 1;
        for(int i = 1 ; i < len ; i++) {
            if(ar[index-1] != ar[i]) {
                ar[index] = ar[i];
                index++;
            }
        }
        return index;
    }
}
