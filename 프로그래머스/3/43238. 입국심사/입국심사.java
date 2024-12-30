class Solution {
    public long solution(int n, int[] times) {
        long l = Long.MAX_VALUE;
        long r = 0;
        for (int i = 0; i < times.length; i++) {
            l = (long) Math.min(l, (long) times[i]);
            r = (long) Math.max(r, (long) n * (long) times[i]);
        }
        
        while (l < r) {
            long mid = (l + r) / 2L;
            long acc = 0;
            
            for (int i = 0; i < times.length; i++) {
                acc += mid / (long) times[i];
            }
            // System.out.println("l: " + l + ", r: " + r + ", mid: " + mid + ", acc: " + acc);
            if (acc >= n) {
                r = mid;
            } else {
                l = mid + 1L;
            }
        }
        
        return l;
    }
}