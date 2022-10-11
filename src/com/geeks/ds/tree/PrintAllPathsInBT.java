package com.geeks.ds.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a binary tree, write an efficient algorithm to print all paths from the root node to every leaf node in it.
 */

/* Construct the following tree
                  1
                /   \
               /     \
              2       3
             / \     / \
            4   5   6   7
                   /     \
                  8       9
*/

public class PrintAllPathsInBT {

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.left = new TreeNode(8);
        root.right.right.right = new TreeNode(9);

        // print all root-to-leaf paths
        Deque<Integer> queue = new ArrayDeque<>();
        printRootToLeafPaths(root, queue);
    }

    public static boolean isLeafNode(TreeNode root) {
        if(root == null) {
            return false;
        }
        return (root.left == null && root.right == null);
    }

    public static void printRootToLeafPaths(TreeNode root, Deque<Integer> path) {

        if(root == null) {
            return;
        }
        path.add(root.data);

        if(isLeafNode(root)) {
            System.out.print(path);
        }

        printRootToLeafPaths(root.left , path);
        printRootToLeafPaths(root.right , path);

        path.removeLast();
    }
}
