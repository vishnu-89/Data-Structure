package com.geeks.ds.tree;

import com.geeks.ds.queue.ArrayQueue;

import java.util.*;

/**
 * Given a binary tree, write an efficient algorithm to find all nodes present at a given distance
 * from any leaf node. We need to find only those nodes that are present in the root-to-leaf path for that leaf.
 */

 /* Construct the following tree
                  15
                /    \
               /      \
              10       20
             / \      /  \
            8   12   16  25
                    /
                   18
*/
public class NodesAtGivenDistance {

    public static void main(String[] args)
    {

        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(10);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(12);
        root.right.left = new TreeNode(16);
        root.right.right = new TreeNode(25);
        root.right.left.left = new TreeNode(18);

        List<TreeNode> list = new ArrayList<>();
        Set<TreeNode> set = new HashSet<>();
        leafNodeDistance(root, 1, list, set);

        for(TreeNode node : set) {
            System.out.print(node.data+" ");
        }

    }

    public static void leafNodeDistance(TreeNode root, int dist, List<TreeNode> path, Set<TreeNode> set) {

        if(root == null) {
            return;
        }

        if(isLeafNode(root) && path.size() >= dist) {
            set.add(path.get(path.size() - dist));
            return;
        }
        path.add(root);

        leafNodeDistance(root.left, dist, path, set);
        leafNodeDistance(root.right, dist, path, set);

        path.remove(root);
    }

    public static boolean isLeafNode(TreeNode root) {
        return (root.left == null && root.right == null);
    }
}
