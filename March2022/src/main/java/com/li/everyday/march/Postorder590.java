package com.li.everyday.march;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lishengxiang
 * Date: 2022/3/12
 * Time: 19:33
 * Description:590. N 叉树的后序遍历
 * 给定一个 n 叉树的根节点 root ，返回 其节点值的 后序遍历 。
 * <p>
 * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[5,6,3,2,4,1]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[2,6,14,11,7,3,12,8,4,13,9,10,5,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 节点总数在范围 [0, 104] 内
 * 0 <= Node.val <= 104
 * n 叉树的高度小于或等于 1000
 * <p>
 * <p>
 * 进阶：递归法很简单，你可以使用迭代法完成此题吗?
 * <p>
 * 通过次数92,352提交次数119,194
 */
public class Postorder590 {
    public List<Integer> postorder(Node root) {
        if (root==null)return null;
        ArrayList<Integer> list = new ArrayList<>();
        if (root.children!=null){
            List<Node> children = root.children;
            for (Node child : children) {
                List<Integer> postorder = postorder(child);
                list.addAll(postorder);
            }
        }else {
            list.add(root.val);
        }
        return list;
    }

    public static void main(String[] args) {
        Node node = new Node(4);
        Postorder590 main = new Postorder590();
        List<Integer> postorder = main.postorder(node);
        System.out.println(postorder);
    }
}
