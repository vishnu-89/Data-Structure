package com.geeks.ds.tree;

/**
 * Given a binary tree, determine the distance between given pairs of nodes in it.
 * The distance between two nodes is defined as the total number of edges
 * in the shortest path from one node to other.
 */

/* Construct the following tree
              1
            /   \
           /     \
          2       3
           \     / \
            4   5   6
               /     \
              7       8
*/
public class DistanceBetweenPairOfNode {

    public static void main(String[] args)
    {


        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        // find the distance between node 7 and node 6
        System.out.print(findDistance(root, root.right.left.left, root.right.right));
    }

    public static int findDistance(TreeNode root, TreeNode x, TreeNode y)
    {
        TreeNode lca = null;

        if (isNodePresent(root, y) && isNodePresent(root, x)) {
            lca = findLCA(root, x, y);
        }
        else {
            return Integer.MIN_VALUE;
        }

        return findLevel(lca, x, 0) + findLevel(lca, y, 0);
    }

    public static TreeNode findLCA(TreeNode root, TreeNode x, TreeNode y)
    {
        if (root == null) {
            return null;
        }
        if (root == x || root == y) {
            return root;
        }
        TreeNode left = findLCA(root.left, x, y);
        TreeNode right = findLCA(root.right, x, y);
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }

        return null;
    }

    public static int findLevel(TreeNode root, TreeNode node, int level)
    {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        if (root == node) {
            return level;
        }

        int left = findLevel(root.left, node, level + 1);
        if (left != Integer.MIN_VALUE) {
            return left;
        }
        return findLevel(root.right, node, level + 1);
    }

    public static boolean isNodePresent(TreeNode root, TreeNode node)
    {
        if (root == null) {
            return false;
        }
        if (root == node) {
            return true;
        }
        return isNodePresent(root.left, node) || isNodePresent(root.right, node);
    }



}
