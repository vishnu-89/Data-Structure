package com.geeks.ds.tree;

import java.util.HashMap;
import java.util.Map;

public class TopAndBottomView {

    public static void main(String [] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.left.left = new TreeNode(7);
        root.right.right = new TreeNode(6);
        root.right.left.right = new TreeNode(8);

        Map<Integer,Integer> topMap = new HashMap<>();

        topView(root,0,topMap);
        System.out.println("Top view of binary tree : ");
        for(Map.Entry<Integer,Integer> entry : topMap.entrySet()) {
            System.out.print(entry.getValue()+" ");
        }

        System.out.println();

        Map<Integer,Integer> bottomMap = new HashMap<>();
        System.out.println("Bottom view of binary tree : ");
        bottomView(root,0,bottomMap);
        for(Map.Entry<Integer,Integer> entry : bottomMap.entrySet()) {
            System.out.print(entry.getValue()+" ");
        }
    }

    public static void topView(TreeNode root, int hd, Map<Integer,Integer> map) {

        if(root == null) {
            return;
        }
        if(!map.containsKey(hd)) {
            map.put(hd,root.data);
        }
        topView(root.left,hd-1,map);
        topView(root.right,hd+1,map);
    }

    public static void bottomView(TreeNode root, int hd, Map<Integer,Integer> map) {

        if(root == null) {
            return;
        }
        map.put(hd,root.data);

        bottomView(root.left,hd-1,map);
        bottomView(root.right,hd+1,map);
    }
}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}