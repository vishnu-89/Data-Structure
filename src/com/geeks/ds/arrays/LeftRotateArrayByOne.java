package com.geeks.ds.arrays;

public class LeftRotateArrayByOne {

    public static void main(String [] args) {
        int [] ar = {4, 0, 20, 0, 100,200};
        int len = ar.length;

        System.out.println("Array before left rotate : ");
        for(int i = 0 ; i < ar.length ; i++) {
            System.out.print(ar[i]+" ");
        }

        leftRotateByOne(ar, len);
        System.out.println();

        System.out.println("Array before left rotate by one : ");
        for(int i = 0 ; i < len ; i++) {
            System.out.print(ar[i]+" ");
        }
    }

    private static void leftRotateByOne(int[] ar, int len) {
        int temp = ar[0];
        int index = 0;
        for(int i = 1 ; i < len ; i++) {
            ar[index++] = ar[i];
        }
        ar[index] = temp;
    }
}
