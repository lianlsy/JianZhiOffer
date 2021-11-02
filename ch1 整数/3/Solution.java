class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i >> 1] + (i & 1);
        }
        return dp;
    }

//    public int[] countBits(int n) {
//        int[] dp = new int[n + 1];
//        dp[0] = 0;
//        for (int i = 1; i < dp.length; i++) {
//            dp[i] = dp[i & (i - 1)] + 1;
//        }
//        return dp;
//    }
}
