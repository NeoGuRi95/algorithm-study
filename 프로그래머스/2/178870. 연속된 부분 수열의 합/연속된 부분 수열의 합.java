class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0, 1000000};
        
        // 투 포인터, 합이 k인 부분 수열 찾기
        int sum = 0;
        int l = 0;
        int r = -1;
        while (r < sequence.length) {
            if (sum == k) {
                int newLen = r - l;
                int orgLen = answer[1] - answer[0];
                if (newLen < orgLen) {
                    answer[0] = l;
                    answer[1] = r;
                }
                sum -= sequence[l];
                l++;
            } else if (sum < k) {
                r++;
                if (r < sequence.length) {
                    sum += sequence[r];
                }
            } else {
                sum -= sequence[l];
                l++;
            }
        }
        
        return answer;
    }
}