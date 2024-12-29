import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int l = Integer.MAX_VALUE;
        int r = 0;
        for (int i = 0; i < stones.length; i++) {
            l = Math.min(l, stones[i]);
            r = Math.max(r, stones[i]);
        }
        
        while (l < r) {
            int mid = (l + r) / 2;
            int jumpSize = 0;
            
            for (int i = 0; i < stones.length; i++) {
                if (stones[i] <= mid) {
                    jumpSize++;
                } else {
                    jumpSize = 0;
                }
                
                if (jumpSize == k) break;
            }
            
            if (jumpSize < k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        
        return l;
    }
}