import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int work : works) {
            pq.offer(work);
        }
        
        for (int i = 0; i < n; i++) {
            int work = pq.poll();
            work--;
            if (work > 0) {
                pq.offer(work);
            } else if (pq.isEmpty()) {
                return 0;
            }
        }
        
        long answer = 0;
        while (!pq.isEmpty()) {
            int remainWork = pq.poll();
            answer += (long) Math.pow(remainWork, 2);
        }
        
        return answer;
    }
}