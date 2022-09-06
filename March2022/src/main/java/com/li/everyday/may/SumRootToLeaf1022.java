package com.li.everyday.may;

/**
 * 1022. 从根到叶的二进制数之和
 * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。
 * <p>
 * 例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
 * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 * <p>
 * 返回这些数字之和。题目数据保证答案是一个 32 位 整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,0,1,0,1,0,1]
 * 输出：22
 * 解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 * 示例 2：
 * <p>
 * 输入：root = [0]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中的节点数在 [1, 1000] 范围内
 * Node.val 仅为 0 或 1
 * 通过次数36,970提交次数49,832
 */
public class SumRootToLeaf1022 {
    int count = 0;

    public int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        recursive(root, 0);
        return count;
    }

    public void recursive(TreeNode root, int rootNum) {
        if (root.left != null || root.right != null) {
            int help = rootNum * 2 + root.val;
            if (root.left != null) {
                recursive(root.left, help);
            }
            if (root.right != null) {
                recursive(root.right, help);
            }
        } else {
            count += rootNum * 2 + root.val;
        }
    }


}
