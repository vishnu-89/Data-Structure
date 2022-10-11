package com.geeks.ds.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary tree, calculate the sum of all nodes for each diagonal having negative slope .
 * Assume that the left and right child of a node makes a 45–degree angle with the parent.
 */

/* Construct the following tree
                   1
                 /   \
                /     \
               2       3
              /      /  \
             /      /    \
            4      5      6
                  / \
                 /   \
                7     8
*/
public class DiagonalSumOfBT {

    public static void main(String[] args)
    {


        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);

        Map<Integer,Integer> map = new HashMap<>();
        diagonalSum(root, 0, map);

        System.out.print(map.values());
    }

    public static void diagonalSum(TreeNode root , int diagonal , Map<Integer,Integer> map) {

        if(root == null) {
            return;
        }

        map.put(diagonal, map.getOrDefault(diagonal,0) + root.data);

        diagonalSum(root.left , diagonal + 1, map);
        diagonalSum(root.right , diagonal, map);
    }
}
