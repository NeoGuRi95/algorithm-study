import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        PriorityQueue<Integer> pqA = new PriorityQueue<>();
        PriorityQueue<Integer> pqB = new PriorityQueue<>();
        
        for (int i = 0; i < A.length; i++) {
            pqA.offer(A[i]);
            pqB.offer(B[i]);
        }
        
        while (!pqB.isEmpty()) {
            int aNum = pqA.peek();
            int bNum = pqB.peek();
            if (aNum < bNum) {
                pqA.poll();
                pqB.poll();
                answer++;
            } else {
                pqB.poll();
            }
        }
        
        return answer;
    }
}