package com.li.everyday.april;

/**
 * Created with IntelliJ IDEA.
 * User: lishengxiang
 * Date: 2022/4/14
 * Time: 13:22
 * Description:
 * 1672. 最富有客户的资产总量
 * 给你一个 m x n 的整数网格 accounts ，其中 accounts[i][j] 是第 i​​​​​​​​​​​​ 位客户在第 j 家银行托管的资产数量。返回最富有客户所拥有的 资产总量 。
 * <p>
 * 客户的 资产总量 就是他们在各家银行托管的资产数量之和。最富有客户就是 资产总量 最大的客户。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：accounts = [[1,2,3],[3,2,1]]
 * 输出：6
 * 解释：
 * 第 1 位客户的资产总量 = 1 + 2 + 3 = 6
 * 第 2 位客户的资产总量 = 3 + 2 + 1 = 6
 * 两位客户都是最富有的，资产总量都是 6 ，所以返回 6 。
 * 示例 2：
 * <p>
 * 输入：accounts = [[1,5],[7,3],[3,5]]
 * 输出：10
 * 解释：
 * 第 1 位客户的资产总量 = 6
 * 第 2 位客户的资产总量 = 10
 * 第 3 位客户的资产总量 = 8
 * 第 2 位客户是最富有的，资产总量是 10
 * 示例 3：
 * <p>
 * 输入：accounts = [[2,8,7],[7,1,3],[1,9,5]]
 * 输出：17
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == accounts.length
 * n == accounts[i].length
 * 1 <= m, n <= 50
 * 1 <= accounts[i][j] <= 100
 * 通过次数65,773提交次数75,376
 */
public class MaximumWealth1672 {
    public int maximumWealth(int[][] accounts) {
        if (accounts == null || accounts.length == 0) {
            return 0;
        }
        int column = accounts.length;
        int row = accounts[0].length;
        int maxRet = 0;
        for (int i = 0; i < column; i++) {
            int temp = 0;
            for (int j = 0; j < row; j++) {
                temp += accounts[i][j];
            }
            maxRet = Math.max(maxRet, temp);
        }
        return maxRet;
    }
}
