package com.geeks.ds.arrays;

public class SecondLargestElementInArray {
    public static void main(String [] args) {
        int [] ar = {20, 10, 20, 4, 100,40,200};
        int len = ar.length;

        System.out.println("The second largest element in an array : "+secondLargestElement(ar,len));
    }

    private static int secondLargestElement(int[] ar, int len) {
        int largest = ar[0];
        int secondLargest = ar[1];

        for(int i = 2 ; i < len ; i++) {
            if(largest < ar[i]) {
                secondLargest = largest;
                largest = ar[i];
            }
            else if( largest > secondLargest && secondLargest < ar[i]) {
                secondLargest = ar[i];
            }
        }

        if(secondLargest > largest) {
            secondLargest = largest;
        }
        return secondLargest;
    }
}
