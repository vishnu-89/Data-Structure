package com.geeks.ds.tree;

/**
 * Given a normal binary tree, convert it into a Left–child right–sibling (LC–RS) binary tree.
 */

/* Construct the following tree
                  1
                /  \
               /    \
              2      3
             / \    /
            4   5  6
                  / \
                 7   8
*/
public class ConvertBTLCRS {

    public static void main(String[] args)
    {


        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);

        convert(root);
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

    public static void convert(TreeNode root) {

        if(root == null) {
            return;
        }

        convert(root.left);
        convert(root.right);

        if(root.left == null) {
            root.left = root.right;
            root.right = null;
        }
        else {
            root.left.right = root.right;
            root.right = null;
        }
    }

}
