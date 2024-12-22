import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        
        int answer = 1;
        int x = targets[0][1];
        
        for (int i = 1; i < targets.length; i++) {
            int[] target = targets[i];
            if (target[0] < x) {
                if (target[1] <= x) {
                    x = target[1];
                } else {
                    continue;
                }
            } else {
                answer++;
                x = target[1];
            }
        }
        
        return answer;
    }
}