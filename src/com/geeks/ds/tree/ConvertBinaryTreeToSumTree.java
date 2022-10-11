package com.geeks.ds.tree;

/**
 * Given a binary tree, in-place replace each node’s value to the sum of all elements present in its left and right subtree.
 * You may assume the value of an empty child node to be 0.
 */
public class ConvertBinaryTreeToSumTree {

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);

        sumTree(root);
        preorder(root);
    }

    public static void preorder(TreeNode root)
    {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static int sumTree(TreeNode root) {

        if(root == null) {
            return 0;
        }
        int left = sumTree(root.left);
        int right = sumTree(root.right);

        int oldValue = root.data;
        root.data = left + right;
        return root.data + oldValue;
    }
}
