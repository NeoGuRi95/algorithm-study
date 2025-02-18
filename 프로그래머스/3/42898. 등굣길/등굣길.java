import java.util.*;

class Solution {
    
    static int MOD = 1000000007;
    
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m];
        
        for (int[] puddle:puddles) {
            dp[puddle[1] - 1][puddle[0] - 1] = -1;
        }
        
        dp[0][0] = 1;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dp[i][j] == -1) {
                    continue;
                }
                if (-1 < i - 1 && dp[i - 1][j] != -1) {
                    dp[i][j] += dp[i - 1][j] % MOD;
                }
                if (-1 < j - 1 && dp[i][j - 1] != -1) {
                    dp[i][j] += dp[i][j - 1] % MOD;
                }
                dp[i][j] %= MOD;
            }
        }
        
        return dp[n - 1][m - 1] % MOD;
    }
}