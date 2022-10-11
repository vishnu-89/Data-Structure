package com.geeks.ds.tree;

/**
 * Given a binary tree, write an efficient algorithm to check if it has a symmetric structure or not,
 * i.e., left and right subtree mirror each other.
 */

/* Symmetric binary tree
              1
            /   \
           /     \
          2       3
           \     /
            5   6
*/
public class CheckBTIsSymmetric {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);

        if (isSymmetric(root)) {
            System.out.print("The binary tree is symmetric");
        } else {
            System.out.print("The binary tree is not symmetric");

        }
    }

    public static boolean isSymmetric(TreeNode root)
    {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public static boolean isSymmetric(TreeNode first, TreeNode second) {

        if(first == null && second == null) {
            return true;
        }

        return first != null && second != null
                && isSymmetric(first.left, second.right)
                && isSymmetric(first.right,second.left);
    }
}