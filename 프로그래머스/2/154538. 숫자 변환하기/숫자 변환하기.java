class Solution {
    public int solution(int x, int y, int n) {
        int[] dp = new int[y + 1];
        
        for (int i = x; i <= y; i++) {
            dp[i] = Integer.MAX_VALUE - 1;
        }
        
        dp[x] = 0;
        for (int i = x; i < y; i++) {
            if (i + n <= y) {
                dp[i + n] = Math.min(dp[i] + 1, dp[i + n]);
            }
            if (i * 2 <= y) {
                dp[i * 2] = Math.min(dp[i] + 1, dp[i * 2]);
            }
            if (i * 3 <= y) {
                dp[i * 3] = Math.min(dp[i] + 1, dp[i * 3]);
            }
        }
        
        if (dp[y] == Integer.MAX_VALUE - 1) dp[y] = -1;
        
        return dp[y];
    }
}