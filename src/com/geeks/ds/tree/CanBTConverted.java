package com.geeks.ds.tree;

/**
 * Given a binary tree, write an efficient algorithm to determine if it can be converted
 * into another binary tree by doing any number of swaps of its right and left branches.
 */
public class CanBTConverted {

    public static void main(String[] args)
    {
        // construct the first tree
        TreeNode X = new TreeNode(6);
        X.left = new TreeNode(3);
        X.right = new TreeNode(8);
        X.left.left = new TreeNode(1);
        X.left.right = new TreeNode(7);
        X.right.left = new TreeNode(4);
        X.right.right = new TreeNode(2);
        X.right.left.left = new TreeNode(1);
        X.right.left.right = new TreeNode(7);
        X.right.right.right = new TreeNode(3);

        // construct the second tree
        TreeNode Y = new TreeNode(6);
        Y.left = new TreeNode(8);
        Y.right = new TreeNode(3);
        Y.left.left = new TreeNode(2);
        Y.left.right = new TreeNode(4);
        Y.right.left = new TreeNode(7);
        Y.right.right = new TreeNode(1);
        Y.left.left.left = new TreeNode(3);
        Y.left.right.left = new TreeNode(1);
        Y.left.right.right = new TreeNode(7);

        if (canConverted(X, Y)) {
            System.out.println("Binary tree can be converted");
        }
        else {
            System.out.println("Binary tree cannot be converted");
        }
    }

    public static boolean canConverted(TreeNode firstRoot, TreeNode secondRoot) {

        if(firstRoot == null && secondRoot == null) {
            return true;
        }
        if(firstRoot == secondRoot) {
            return true;
        }

        return (firstRoot != null && secondRoot != null)
                && (firstRoot.data == secondRoot.data)
                && ((canConverted(firstRoot.left ,secondRoot.left) && canConverted(firstRoot.right ,secondRoot.right))
                || (canConverted(firstRoot.right ,secondRoot.left) && canConverted(firstRoot.left ,secondRoot.right)));
    }
}
