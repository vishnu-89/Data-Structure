package com.geeks.ds.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers and a sum B, find all unique combinations in the array where the sum is equal to B.
 * The same number may be chosen from the array any number of times to make B.
 */
public class CombinationSum {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(4);
        arr.add(6);
        arr.add(8);

        int sum = 8;

        ArrayList<ArrayList<Integer>> ans = combinationSum(arr, sum);

        if (ans.size() == 0) {
            System.out.println("Empty");
            return;
        }

        for (int i = 0; i < ans.size(); i++) {

            System.out.print("(");
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.print(")");
        }
    }

    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> arr, int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();

        Set<Integer> set = new HashSet<>(arr);
        arr.clear();
        arr.addAll(set);
        Collections.sort(arr);

        findNumbers(ans, arr, sum, 0, temp);
        return ans;
    }

    static void findNumbers(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> arr, int sum, int index, ArrayList<Integer> temp) {

        if (sum == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < arr.size(); i++) {
            if ((sum - arr.get(i)) >= 0) {
                temp.add(arr.get(i));
                findNumbers(ans, arr, sum - arr.get(i), i, temp);
                temp.remove(arr.get(i));
            }
        }
    }

}
