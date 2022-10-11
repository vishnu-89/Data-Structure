package com.geeks.ds.tree;

/**
 * Given a binary tree, check if it is a sum tree or not. In a sum tree, each non-leaf node’s
 * value is equal to the sum of all elements present in its left and right subtree.
 */
public class CheckBinaryTreeIsSumTree {

    public static void main(String[] args)
    {
        /* Construct the following tree
                 44
                /  \
               /    \
              9     13
             / \    / \
            4   5  6   7
        */

        TreeNode root = new TreeNode(44);
        root.left = new TreeNode(9);
        root.right = new TreeNode(13);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        if (isSumTree(root) != Integer.MIN_VALUE) {
            System.out.println("Binary tree is a sum tree");
        }
        else {
            System.out.println("Binary tree is not a sum tree");
        }
    }

    public static int isSumTree(TreeNode root) {

        if(root == null) {
            return 0;
        }

        if(root.left == null && root.right == null) {
            return root.data;
        }

        int left = isSumTree(root.left);
        int right = isSumTree(root.right);

        if(left != Integer.MIN_VALUE && right != Integer.MIN_VALUE && root.data == left+right) {
            return 2*root.data;
        }

        return Integer.MIN_VALUE;
    }
}
