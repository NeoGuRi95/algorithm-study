import java.util.*;

class Solution {

    public long solution(int r1, int r2) {
        long answer = 0;
        
        long r1s = (long) Math.pow(r1, 2);
        long r2s = (long) Math.pow(r2, 2);
        
        for (int x = 1; x <= r2; x++) {
            long xs = (long) Math.pow(x, 2);
            int minY = (int) Math.ceil(Math.sqrt(r1s - xs));
            int maxY = (int) Math.floor(Math.sqrt(r2s - xs));
            answer += maxY - minY + 1;
        }
        
        return 4*answer;
    }
    
}