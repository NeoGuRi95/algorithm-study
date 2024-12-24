class Solution {
    public int solution(int n, int[] stations, int w) {
        int range = 2*w+1;
        int answer = 0;
        int start = 1;
        
        for (int station : stations) {
            int left = Math.max(station - w, start);
            int right = Math.min(station + w, n);
            answer += getTower(left - start, range);
            start = right + 1;
        }
        
        answer += getTower(n + 1 - start, range);

        return answer;
    }
    
    public int getTower(int emptyCnt, int range) {
        if (emptyCnt <= 0) return 0;
        if (emptyCnt%range == 0) {
            return emptyCnt/range;
        } else {
            return emptyCnt/range + 1;
        }
    }
}