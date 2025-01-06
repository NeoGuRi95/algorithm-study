import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        
        int startIdx = 0;
        for (int a = 0; a < number.length() - k; a++) {
            int max = 0;
            int i = startIdx;
            while (i - a <= k) {
                int num = number.charAt(i) - '0';
                if (num > max) {
                    max = num;
                    startIdx = i + 1;
                }
                i++;
            }
            sb.append(max);
        } 
        
        return sb.toString();
    }
}