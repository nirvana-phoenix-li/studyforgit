package com.li.everyday.september;


import com.li.domain.TreeNode;

import java.util.HashSet;

/**
 * 687. 最长同值路径
 * 给定一个二叉树的 root ，返回 最长的路径的长度 ，这个路径中的 每个节点具有相同值 。 这条路径可以经过也可以不经过根节点。
 * <p>
 * 两个节点之间的路径长度 由它们之间的边数表示。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入：root = [5,4,5,1,1,5]
 * 输出：2
 * 示例 2:
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,4,5,4,4,5]
 * 输出：2
 * <p>
 * <p>
 * 提示:
 * <p>
 * 树的节点数的范围是 [0, 104]
 * -1000 <= Node.val <= 1000
 * 树的深度将不超过 1000
 * 通过次数64,924提交次数139,482
 */
public class LongestUnivaluePath687 {

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        HashSet<TreeNode> helpSet = new HashSet<>();
        int max = 0;

        while (root.left != null || root.right != null) {

        }

        return 0;
    }
}
