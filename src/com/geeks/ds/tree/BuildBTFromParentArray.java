package com.geeks.ds.tree;

import java.util.HashMap;
import java.util.Map;

/**
     Given an integer array representing a binary tree, such that the parent-child relationship
     is defined by (A[i], i) for every index i in array A, build a binary tree out of it. The root node’s value
     is i if -1 is present at index i in the array. It may be assumed that the input provided to the program is valid.
 */
public class BuildBTFromParentArray {

    public static void main(String[] args)
    {
        int[] parent = {-1, 0, 0, 1, 2, 2, 4, 4};

        TreeNode root = createTree(parent);
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

    public static TreeNode createTree(int[] parent) {

        Map<Integer , TreeNode> map = new HashMap<>();
        for(int i = 0 ; i < parent.length ; i++) {
            map.put(i, new TreeNode(i));
        }

        TreeNode root = null;
        for(int i = 0 ; i < parent.length ; i++) {

            if(parent[i] == -1) {
                root = map.get(i);
            }
            else {
                TreeNode temp = map.get(parent[i]);

                if(temp.left != null) {
                    temp.right = map.get(i);
                }
                else {
                    temp.left = map.get(i);
                }
            }
        }
        return root;
    }
}
