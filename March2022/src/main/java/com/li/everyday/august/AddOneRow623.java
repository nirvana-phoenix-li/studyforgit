package com.li.everyday.august;


import com.li.domain.TreeNode;

/**
 * 623. 在二叉树中增加一行
 * 给定一个二叉树的根 root 和两个整数 val 和 depth ，在给定的深度 depth 处添加一个值为 val 的节点行。
 * <p>
 * 注意，根节点 root 位于深度 1 。
 * <p>
 * 加法规则如下:
 * <p>
 * 给定整数 depth，对于深度为 depth - 1 的每个非空树节点 cur ，创建两个值为 val 的树节点作为 cur 的左子树根和右子树根。
 * cur 原来的左子树应该是新的左子树根的左子树。
 * cur 原来的右子树应该是新的右子树根的右子树。
 * 如果 depth == 1 意味着 depth - 1 根本没有深度，那么创建一个树节点，值 val 作为整个原始树的新根，而原始树就是新根的左子树。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入: root = [4,2,6,3,1,5], val = 1, depth = 2
 * 输出: [4,1,1,2,null,null,6,3,1,5]
 * 示例 2:
 * <p>
 * <p>
 * <p>
 * 输入: root = [4,2,null,3,1], val = 1, depth = 3
 * 输出:  [4,2,null,1,1,3,null,null,1]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 节点数在 [1, 104] 范围内
 * 树的深度在 [1, 104]范围内
 * -100 <= Node.val <= 100
 * -105 <= val <= 105
 * 1 <= depth <= the depth of tree + 1
 * 通过次数30,869提交次数51,896
 */

public class AddOneRow623 {
    private int depth = 0;
    private int val = 0;

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (root == null) return root;
        this.depth = depth;
        this.val = val;
        int currentDepth = 1;
        recursion(root, 0);
        return root;
    }

    public void recursion(TreeNode root, int curDepth) {
        if (curDepth+2 != depth) {
            if (root.left != null) {
                recursion(root.left, curDepth + 1);
            }
            if (root.right != null) {
                recursion(root.right, curDepth + 1);
            }
        } else {
            if (root.left != null) {
                TreeNode left = root.left;
                TreeNode helpNode = new TreeNode(val);
                root.left = helpNode;
                helpNode.left = left;
            }
            if (root.right != null) {
                TreeNode right = root.right;
                TreeNode helpNode = new TreeNode(val);
                root.right = helpNode;
                helpNode.right = right;
            }
        }
    }

    public static void main(String[] args) {
        AddOneRow623 main = new AddOneRow623();
        TreeNode treeNode1 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(6);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(1);
        TreeNode treeNode6 = new TreeNode(5);
        treeNode1.left=treeNode2;
        treeNode1.right=treeNode3;
        treeNode2.left=treeNode4;
        treeNode2.right=treeNode5;
        treeNode3.left=treeNode6;
        TreeNode treeNode = main.addOneRow(treeNode1, 1, 2);
        System.out.println(true);
    }

}
