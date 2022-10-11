package com.geeks.ds.tree;

/**
 * Given a binary tree, convert it into a full tree by removing half nodes (remove nodes having one child).
 * A full binary tree is a tree in which every node other than the leaves has two children.
 */

/* Following tree is constructed
                     0
                   /   \
                  /     \
                 1       2
                /        /
               /        /
              3        4
             /        / \
            /        /   \
           5        6     7
*/
public class ConvertBTFullBT {

    public static void main(String[] args)
    {


        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.left.left.left = new TreeNode(5);
        root.right.left.left = new TreeNode(6);
        root.right.left.right = new TreeNode(7);

        root = truncate(root);
        inorder(root);
    }

    public static TreeNode truncate(TreeNode root) {

        if(root == null) {
            return null;
        }
        root.left = truncate(root.left);
        root.right = truncate(root.right);

        if((root.left != null && root.right != null) || isLeaf(root)) {
            return root;
        }

        return root.left != null ? root.left : root.right;
    }

    public static boolean isLeaf(TreeNode node) {
        return (node.left == null && node.right == null);
    }

    public static void inorder(TreeNode root)
    {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}
