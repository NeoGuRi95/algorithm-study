class Solution {
    int solution(int[][] land) {
        int[][] dp = new int[land.length][4];
        
        for (int i = 0; i < 4; i++) {
            dp[0][i] = land[0][i];
        }
        
        for (int i = 1; i < land.length; i++) { // 행
            for (int j = 0; j < 4; j++) { // 현재 열
                for (int z = 0; z < 4; z++) { // 이전 열
                    if (j == z) continue;
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][z] + land[i][j]);
                }
            }
        }
        
        int answer = 0;
        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer, dp[land.length - 1][i]);
        }

        return answer;
    }
}