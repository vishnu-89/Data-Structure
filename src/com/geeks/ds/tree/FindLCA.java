package com.geeks.ds.tree;

/**
 * Given a binary tree and two nodes, x and y, find the lowest common ancestor (LCA) of x and y in it.
 * The solution should return null if either x or y is not the actual node in the tree.
 */

/* Construct the following tree
              1
            /   \
           /     \
          2       3
           \     / \
            4   5   6
               / \
              7   8
*/
public class FindLCA {

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

        findLCA(root, root.right.left.left, root.right.right);
        findLCA(root, root.right.left.left, new TreeNode(10));
        findLCA(root, root.right.left.left, root.right.left.left);
        findLCA(root, root.right.left.left, root.right.left);
        findLCA(root, root.left, root.right.left);
    }

    public static void findLCA(TreeNode root, TreeNode x, TreeNode y)
    {
        TreeNode lca = null;
        NodeWrapper LCA = new NodeWrapper(lca);
        if (isNodePresent(root, y) && isNodePresent(root, x))
        {
            findLCA(root, LCA, x, y);
            lca = LCA.node;
        }
        if (lca != null) {
            System.out.println("LCA is " + lca.data);
        }
        else {
            System.out.println("LCA does not exist");
        }
    }

    public static boolean findLCA(TreeNode root, NodeWrapper lca, TreeNode x, TreeNode y)
    {
        if (root == null) {
            return false;
        }
        if (root == x || root == y)
        {
            lca.node = root;
            return true;
        }
        boolean left = findLCA(root.left, lca, x, y);
        boolean right = findLCA(root.right, lca, x, y);
        if (left && right) {
            lca.node = root;
        }
        return left || right;
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

    static class NodeWrapper
    {
        public TreeNode node;

        NodeWrapper(TreeNode node) {
            this.node = node;
        }
    }


}
