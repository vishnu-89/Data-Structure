package com.geeks.ds.tree;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Given a binary tree, write an efficient algorithm to check if it is height-balanced or not.
 * In a height-balanced tree, the absolute difference between the height of the
 * left and right subtree for every node is 0 or 1.
 */
/* Construct the following tree
                  1
                /   \
               /     \
              2       3
             / \     /
            4   5   6
 */

public class IsBTHeightBalanced {

    public static void main(String[] args)
    {


        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        AtomicBoolean isBalanced = new AtomicBoolean(true);
        isHeightBalanced(root, isBalanced);

        System.out.println("Binary tree is balanced "+isBalanced.get());

    }

    public static int isHeightBalanced(TreeNode root, AtomicBoolean isBalanced)
    {
        if (root == null || !isBalanced.get()) {
            return 0;
        }
        int left_height = isHeightBalanced(root.left, isBalanced);
        int right_height = isHeightBalanced(root.right, isBalanced);

        if (Math.abs(left_height - right_height) > 1) {
            isBalanced.set(false);
        }

        return Math.max(left_height, right_height) + 1;
    }

}
