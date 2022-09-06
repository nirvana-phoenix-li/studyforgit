package com.li.domain;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

   public TreeNode() {
    }

    public  TreeNode(int val) {
        this.val = val;
    }

    public   TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.right = right;
        this.left = left;
    }
}