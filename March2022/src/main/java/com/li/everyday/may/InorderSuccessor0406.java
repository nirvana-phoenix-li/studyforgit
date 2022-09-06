package com.li.everyday.may;

public class InorderSuccessor0406 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        if (root.val == p.val) {
            TreeNode help = root.right;
            while (help!=null&& help.left != null) {
                help = help.left;
            }
            return help;
        } else if (root.val < p.val) {
            if (root.right != null){
                inorderSuccessor(root.right,p);
            }
        }else if (root.val >p.val){
            if (root.left != null){
                inorderSuccessor(root.left,p);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode rootNode = new TreeNode(2);
        rootNode.left=new TreeNode(1);
        rootNode.right=new TreeNode(3);
        InorderSuccessor0406 main = new InorderSuccessor0406();
        TreeNode treeNode = main.inorderSuccessor(rootNode, rootNode.left);
        System.out.println(treeNode.val);
    }
}
