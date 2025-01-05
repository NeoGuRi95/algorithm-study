class Solution {
    public int[] solution(int n) {
        int totalCnt = (n + 1) * n / 2;
        int[] answer = new int[totalCnt];
        int idx = 0;
        int num = 1;
        int step = 1;
        int direction = 1; // 1: down, 2: right, 3: up
        
        while (true) {
            answer[idx] = num;
            
            if (num == totalCnt) break;
            
            if ((idx + step >= totalCnt || answer[idx + step] != 0) && direction == 1) {
                direction = 2;
            } else if ((idx + 1 >= totalCnt || answer[idx + 1] != 0) && direction == 2) {
                direction = 3;
            } else if ((idx - step < 0 || answer[idx - step] != 0) && direction == 3) {
                direction = 1;
            }
            
            if (direction == 1) {
                idx += step;
                step += 1;
            } else if (direction == 2) {
                idx += 1;
            } else {
                idx -= step;
                step -= 1;
            }
            
            num++;
        }
        
        return answer;
    }
}