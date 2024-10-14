import java.util.Arrays;

class Solution {
    int MOD = 20170805;
    
    public Boolean OOB(int i, int j, int m, int n) {
        if (i < 0 || i >= m)
            return true;
        if (j < 0 || j >= n)
            return true;
        return false;
    }
    
    public int solution(int m, int n, int[][] cityMap) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        // System.out.println(dp[0][0]);
        for (int i = 0; i < m; i++) {
            // System.out.println(i);
            for (int j = 0; j < n; j++){
                if (cityMap[i][j] == 0) {
                    // from up
                    if (OOB(i - 1, j, m, n) == false) {
                        dp[i][j] += dp[i - 1][j];
                        dp[i][j] %= MOD;   
                    }
                    // from left
                    if (OOB(i, j - 1, m, n) == false) {
                        dp[i][j] += dp[i][j - 1];
                        dp[i][j] %= MOD;
                    }
                } else if (cityMap[i][j] == 1) {
                    continue;
                } else if (cityMap[i][j] == 2) {
                    // System.out.println("i, j: " + i + ", " + j);
                    // from up
                    if (OOB(i - 1, j, m, n) == false) {
                        int ni = i + 1;
                        // until not 2
                        while (OOB(ni, j, m, n) == false && cityMap[ni][j] == 2) {
                            ni += 1;
                        }
                        if (OOB(ni, j, m, n) == false && cityMap[ni][j] == 0) {
                            dp[ni][j] += dp[i - 1][j];
                            dp[ni][j] %= MOD;
                        }
                    }
                    // from left
                    if (OOB(i, j - 1, m, n) == false) {
                        int nj = j + 1;
                        // until not 2
                        while (OOB(i, nj, m, n) == false && cityMap[i][nj] == 2) {
                            nj += 1;
                        }
                        if (OOB(i, nj, m, n) == false && cityMap[i][nj] == 0) {
                            dp[i][nj] += dp[i][j - 1];
                            dp[i][nj] %= MOD;
                        }
                        // System.out.println("i, nj: " + i + ", " + nj);
                    }
                }
            }
        }
        // System.out.println(Arrays.deepToString(dp));
        return dp[m - 1][n - 1];
    }
}