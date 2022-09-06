package com.li.everyday.july.m7_3;

public class Solution3 {

    static final int MOD = (int) 1e9 + 7;

    public static void main(String[] args) {
        Solution3 main = new Solution3();
        int i = main.peopleAwareOfSecret2(4, 1, 3);
        System.out.println(i);
    }

    public int peopleAwareOfSecret2(int n, int delay, int forget) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int temp = (dp[Math.max(i - delay, 0)] - dp[Math.max(i - forget, 0)])%MOD;

            dp[i] = (temp+dp[i - 1])%MOD;
        }
        return ((dp[n] - dp[Math.max(0, n - forget)]) % MOD + MOD) % MOD;

    }

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        var sum = new int[n + 1];
        sum[1] = 1;
        for (var i = 2; i <= n; i++) {
            var f = (sum[Math.max(i - delay, 0)] - sum[Math.max(i - forget, 0)]) % MOD;
            sum[i] = (sum[i - 1] + f) % MOD;
        }
        return ((sum[n] - sum[Math.max(0, n - forget)]) % MOD + MOD) % MOD; // 防止结果为负数
    }

}
