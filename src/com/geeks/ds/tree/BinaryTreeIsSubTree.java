package com.geeks.ds.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, determine whether it is a subtree of another binary tree.
 * A subtree of a tree T is a tree consisting of a node in T and all of its descendants in T.
 */

 /* Below Tree is subtree
                 1
                /  \
               /    \
              2     3                  3
             / \    / \               /  \
            4   5  6   7             6     7
*/
public class BinaryTreeIsSubTree {

    public static void main(String[] args)
    {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        if (checkSubtree(root, root.right)) {
            System.out.print("Yes");
        }
        else {
            System.out.print("No");
        }
    }

    public static boolean checkSubtree(TreeNode root, TreeNode subRoot) {

        if(root == null) {
            return false;
        }
        if(subRoot == null) {
            return true;
        }

        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();

        inOrderTraversal(root, firstList);
        inOrderTraversal(root, secondList);

        if(!isSubList(firstList,secondList)) {
            return false;
        }

        firstList.clear();
        secondList.clear();

        postOrderTraversal(root,firstList);
        postOrderTraversal(root,secondList);

        if(!isSubList(firstList,secondList)) {
            return false;
        }

        return true;
    }

    public static boolean isSubList(List<Integer> firstList, List<Integer> secondList) {

        for(int i = 0 ; i < firstList.size() - secondList.size() + 1 ; i++) {
            if(firstList.subList(i, i + secondList.size()).equals(secondList)) {
                return true;
            }
        }
        return false;
    }
    public static void inOrderTraversal(TreeNode root, List<Integer> list) {

        if(root == null) {
            return;
        }
        inOrderTraversal(root.left,list);
        list.add(root.data);
        inOrderTraversal(root.right,list);
    }

    public static void postOrderTraversal(TreeNode root, List<Integer> list) {

        if(root == null) {
            return;
        }
        postOrderTraversal(root.left,list);
        postOrderTraversal(root.right,list);
        list.add(root.data);
    }
}
