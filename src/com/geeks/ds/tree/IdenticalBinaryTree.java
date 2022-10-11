package com.geeks.ds.tree;

/**
 * Given two binary tree find if its identical
 */
public class IdenticalBinaryTree {

    public static void main(String [] args) {

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(7);


        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);
        root2.right.left = new TreeNode(6);
        root2.right.right = new TreeNode(7);

        System.out.println("Is tree identical : " + identicalTree(root1,root2));

    }

    public static boolean identicalTree(TreeNode root1, TreeNode root2) {

        if(root1 == null && root2 == null) {
            return true;
        }

        return (root1 != null && root2 != null)
                && (root1.data == root2.data)
                && identicalTree(root1.left,root2.left)
                && identicalTree(root1.right,root2.right);
    }
}
