package com.geeks.ds.tree;

/**
 * Given a binary tree, write an efficient algorithm to convert the binary tree into its mirror.
 */

/* Following Binary tree is mirror of each other
                  1
                /   \
               /     \
              2       3
             / \     / \
            4   5   6   7

                  1
                /   \
               /     \
              3       2
             / \     / \
            7   6   5   4
 */
public class ConvertBTMirrorTree {

    public static void main(String[] args)
    {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        convertToMirror(root);
        preorder(root);
    }

    public static void convertToMirror(TreeNode root) {

        if(root == null) {
            return;
        }
        convertToMirror(root.left);
        convertToMirror(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
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
}
