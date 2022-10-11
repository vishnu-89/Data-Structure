package com.geeks.ds.arrays;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers
 * For example, the next permutation of arr = [1,2,3] is [1,3,2].
 */
public class NextPermutation {

    public static void main(String[] args) {
        int[] ar = {4, 5, 2, 6, 7, 3, 1};

        ar = nextPermutation(ar);

        for (int i : ar) {
            System.out.print(i + " ");
        }
    }

    public static int[] nextPermutation(int[] nums) {
        if (nums == null || nums.length == 1) return null;
        int left = nums.length - 2;
        int right = nums.length - 1;

        while (left >= 0 && nums[left] >= nums[left + 1]) {
            left--;
        }
        if (left >= 0) {
            while (right >= 0 && nums[right] <= nums[left]) {
                right--;
            }
            swap(nums, left, right);
        }

        reverse(nums, left + 1, nums.length - 1);

        return nums;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start <= end) {
            swap(nums, start++, end--);
        }
    }
}
