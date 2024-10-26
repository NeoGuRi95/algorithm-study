import java.util.*;

class Solution {
    public String conversion(int num, int n) {
        StringBuilder sb = new StringBuilder();
        
        while (num > 0) {
            if (num % n < 10) {
                sb.append(num % n);
            } else {
                sb.append((char) (num % n - 10 + 'A'));
            }
            num /= n;
        }
        
        return sb.reverse().toString();
    }
    
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        sb.append('0');
        
        int num = 0;
        while (num < t * m) {
            sb.append(conversion(num, n));
            num += 1;
        }
        String result = sb.toString();

        String answer = "";
        int count = 0;
        while (count < t) {
            int idx = m * count + p - 1;
            answer += result.charAt(idx);
            count += 1;
        }
        
        return answer;
    }
}