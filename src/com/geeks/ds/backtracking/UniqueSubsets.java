package com.geeks.ds.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given an array arr[] of integers of size N that might contain duplicates,
 * the task is to find all possible unique subsets.
 */
public class UniqueSubsets {

    public static void main(String[] args) {

        List<List<Integer>> subset = new ArrayList<>();

        ArrayList<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);

        findSubsets(subset, input, new ArrayList<>(), 0);

        Collections.sort(subset, (o1, o2) -> {
            int n = Math.min(o1.size(), o2.size());
            for (int i = 0; i < n; i++) {
                if (o1.get(i) == o2.get(i)) {
                    continue;
                } else {
                    return o1.get(i) - o2.get(i);
                }
            }
            return 1;
        });

        for (int i = 0; i < subset.size(); i++) {
            for (int j = 0; j < subset.get(i).size(); j++) {
                System.out.print(subset.get(i).get(j) + " ");
            }
            System.out.println();
        }

    }

    public static void findSubsets(List<List<Integer>> subset, ArrayList<Integer> nums, ArrayList<Integer> output, int index) {
        if (index == nums.size()) {
            subset.add(output);
            return;
        }

        findSubsets(subset, nums, new ArrayList<>(output), index + 1);
        output.add(nums.get(index));
        findSubsets(subset, nums, new ArrayList<>(output), index + 1);
    }
}
