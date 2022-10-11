package com.geeks.ds.arrays;

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to
 * the product of all the elements of nums except nums[i]
 */
public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] ar = {1,2,0,4,5};

        ar = productExceptSelfWithoutDivision(ar);

        for (int i : ar) {
            System.out.print(i + " ");
        }
    }
    public static int[] productExceptSelf(int[] nums) {
        int mul = 1;
        int countZero = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                countZero++;
            } else {
                mul *= nums[i];
            }
        }
        if(countZero > 1) {
            return new int[nums.length];
        }
        for (int i = 0; i < nums.length; i++) {
            if(countZero == 1) {
                if(nums[i] == 0) nums[i] = mul;
                else nums[i] = 0;
            } else {
                nums[i] = mul / nums[i];
            }
        }
        return nums;
    }

    // Without using division
    public static int[] productExceptSelfWithoutDivision(int[] nums) {
        int[] left = new int[nums.length];
        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        int[] right = new int[nums.length];
        right[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = left[i] * right[i];
        }
        return nums;
    }
}
