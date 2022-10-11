package com.geeks.ds.tree;

/**
 * Given a binary tree containing many zero nodes, sink nodes having zero value at the bottom
 * of the subtree rooted at that node. In other words, the output binary tree should not contain
 * any node having zero value that is the parent of the node having a non-zero value.
 */

 /* Construct the following tree
                  0
                /   \
               /     \
              1       0
                    /   \
                   /     \
                  0       2
                /   \
               /     \
              3       4
*/

public class SinkNodeContainingZero {

    public static void main(String[] args)
    {

        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(2);
        root.right.left.left = new TreeNode(3);
        root.right.left.right = new TreeNode(4);

        sinkNodes(root);

        inorder(root);
    }

    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void sinkNodes(TreeNode root)
    {
        if (root == null) {
            return;
        }

        sinkNodes(root.left);
        sinkNodes(root.right);
        if (root.data == 0) {
            sink(root);
        }
    }

    public static void sink(TreeNode root) {

        if(root == null) {
            return;
        }

        if(root.left != null && root.data != 0) {
            int temp = root.data;
            root.data = root.left.data;
            root.left.data = temp;

            sink(root.left);
        }

        if(root.right != null && root.data != 0) {
            int temp = root.data;
            root.data = root.right.data;
            root.right.data = temp;

            sink(root.right);
        }

    }

}
