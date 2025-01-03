import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();
        long s1 = 0;
        long s2 = 0;
        
        for (int i = 0; i < queue1.length; i++) {
            que1.offer(queue1[i]);
            s1 += queue1[i];
            que2.offer(queue2[i]);
            s2 += queue2[i];
        }
        
        if (s1 == s2) return 0;
        if ((s1 + s2) % 2 == 1) return -1;
        
        int answer = 0;
        while (s1 != s2 && answer <= (queue1.length + queue2.length) * 2) {
            if (s1 < s2) {
                int num = que2.poll();
                s1 += num;
                s2 -= num;
                que1.offer(num);
                answer++;
            } else if (s1 > s2) {
                int num = que1.poll();
                s2 += num;
                s1 -= num;
                que2.offer(num);
                answer++;
            }
            if (s1 == s2) return answer;
        }
        
        return -1;
    }
}