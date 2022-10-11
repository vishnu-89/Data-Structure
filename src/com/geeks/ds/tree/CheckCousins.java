package com.geeks.ds.tree;

/**
 * Given a binary tree, determine if two given nodes are cousins of each other or not.
 * Two nodes of a binary tree are cousins of each other only if they have different parents,
 * but they are at the same level.
 *
 */
public class CheckCousins {

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        if (checkCousins(root, root.left.right, root.right.left)) {
            System.out.println("Nodes are cousins of each other");
        }
        else {
            System.out.println("Nodes are not cousins of each other");
        }
    }

    public static boolean checkCousins(TreeNode root, TreeNode a, TreeNode b) {

        if(root == null) {
            return false;
        }

        NodeInfo x = new NodeInfo(0,a,null);
        NodeInfo y = new NodeInfo(0,b,null);

        updateLevelAndParent(root, null,0, x,y);

        return (x.level == y.level) && (x.parent != y.parent);
    }

    public static void updateLevelAndParent(TreeNode root, TreeNode parent, int level, NodeInfo x, NodeInfo y) {

        if(root == null) {
            return;
        }
        updateLevelAndParent(root.left, root,level-1, x, y);

        if(root == x.node) {
            x.level = level;
            x.parent = parent;
        }

        if(root == y.node) {
            y.level = level;
            y.parent = parent;
        }

        updateLevelAndParent(root.right, root,level+1, x, y);
    }

    static class NodeInfo {
        int level;
        TreeNode node;
        TreeNode parent;

        public NodeInfo(int level, TreeNode node, TreeNode parent) {
            this.level = level;
            this.node = node;
            this.parent = parent;
        }
    }
}
