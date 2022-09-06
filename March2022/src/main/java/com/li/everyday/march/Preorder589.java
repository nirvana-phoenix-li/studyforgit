package com.li.everyday.march;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lishengxiang
 * Date: 2022/3/10
 * Time: 10:08
 * Description:
 * 589. N 叉树的前序遍历
 * 给定一个 n 叉树的根节点  root ，返回 其节点值的 前序遍历 。
 * <p>
 * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[1,3,5,6,2,4]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[1,2,3,6,7,11,14,4,8,12,5,9,13,10]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 节点总数在范围 [0, 104]内
 * 0 <= Node.val <= 104
 * n 叉树的高度小于或等于 1000
 * <p>
 * <p>
 * 进阶：递归法很简单，你可以使用迭代法完成此题吗?
 * <p>
 * 通过次数111,522提交次数147,988
 */
public class Preorder589 {

    public List<Integer> preorder(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        Deque<Node> deque = new LinkedList<>();
        deque.addLast(root);
        while (deque.size() != 0) {
            Node node = deque.pollFirst();
            if (node != null) {
                list.add(node.val);
                if (node.children != null) {
                    for (Node child : node.children) {
                        deque.addFirst(child);
                    }
                }
            }
        }
        return list;
    }
}

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

