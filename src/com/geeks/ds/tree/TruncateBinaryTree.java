package com.geeks.ds.tree;

/**
 * Given a binary tree and a number k, remove nodes from the tree which lie on
 * a complete path having a sum less than k. A complete path in a binary tree is
 * defined as a path from the root to a leaf. The sum of all nodes on that path is defined as the sum of that path.
 */


/* Following tree is constructed
                  6
                /   \
               /     \
              3       8
                    /   \
                   /     \
                  4       2
                /   \      \
               /     \      \
              1       7      3
*/
public class TruncateBinaryTree {

    public static void main(String[] args)
    {

        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(2);
        root.right.left.left = new TreeNode(1);
        root.right.left.right = new TreeNode(7);
        root.right.right.right = new TreeNode(3);

        int k = 20;
        root = truncate(root, k,0);
        inorder(root);
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

    public static boolean isLeaf(TreeNode node) {
        return (node.left == null && node.right == null);
    }

    public static TreeNode truncate(TreeNode curr, int k, int target) {

        if (curr == null) {
            return null;
        }

        target = target + (curr.data);
        curr.left = truncate(curr.left, k, target);
        curr.right = truncate(curr.right, k, target);

        if (target < k && isLeaf(curr))
        {
            return null;
        }

        return curr;

    }

}
