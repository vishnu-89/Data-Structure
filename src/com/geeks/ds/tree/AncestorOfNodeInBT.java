package com.geeks.ds.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a binary tree, find all ancestors of a given node in it.
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
        The ancestor of node 8 are 5, 3 and 1
        The ancestor of node 6 is 3 and 1
        The ancestor of node 4 is 2 and 1
*/

public class AncestorOfNodeInBT {

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

        TreeNode node = root.right.right;

        Deque<Integer> queue = new ArrayDeque<>();
        printAncestors(root, node, queue);

    }

    public static void printAncestors(TreeNode root, TreeNode node, Deque<Integer> path) {

        if(root == null) {
            return;
        }
        path.add(root.data);

        printAncestors(root.left ,node, path);

        if(root.data == node.data) {
            path.removeLast();
            System.out.print(path);
            return;
        }
        printAncestors(root.right ,node, path);

        path.removeLast();
    }


}
