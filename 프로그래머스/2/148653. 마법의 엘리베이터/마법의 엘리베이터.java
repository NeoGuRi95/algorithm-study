import java.util.*;

class Solution {
    
    int answer = Integer.MAX_VALUE;
    
    public int solution(int storey) {
        dfs(0, storey);
        return answer;
    }
    
    public void dfs(int cnt, int storey) {
        if (0 < storey && storey <= 5) {
            answer = Math.min(answer, cnt + storey);
            return;
        } else if (5 < storey && storey < 10) {
            answer = Math.min(answer, cnt + 10 - storey + 1);
            return;
        }
        int remain = storey % 10;
        int nextStorey = storey / 10;
        // down
        dfs(cnt + remain, nextStorey);
        // up
        dfs(cnt + 10 - remain, nextStorey + 1);
    }
}