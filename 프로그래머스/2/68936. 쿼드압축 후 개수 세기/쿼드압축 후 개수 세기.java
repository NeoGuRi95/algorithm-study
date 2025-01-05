import java.util.*;

class Solution {
    
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        int n = arr.length;
        boolean[][] ended = new boolean[n][n];
        
        if (n == 2) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == 0) answer[0]++;
                    else answer[1]++;
                }
            }
            if (answer[0] == 4) {
                answer[0] = 1;
            } else if (answer[1] == 4) {
                answer[1] = 1;
            }
            return answer;
        }
        
        
        int step = 2;
        while (step <= n) {
            for (int i = 0; i < n; i+=step) {
                for (int j = 0; j < n; j+=step) {
                    int d = step / 2;
                    if (arr[i][j] == arr[i + d][j] &&
                       arr[i][j] == arr[i][j + d] &&
                       arr[i][j] == arr[i + d][j + d] &&
                       ended[i][j] == false &&
                       ended[i + d][j] == false &&
                       ended[i][j + d] == false &&
                       ended[i + d][j + d] == false) {
                        arr[i + d][j] = -1;
                        arr[i][j + d] = -1;
                        arr[i + d][j + d] = -1;
                    } else {
                        ended[i][j] = true;
                        ended[i + d][j] = true;
                        ended[i][j + d] = true;
                        ended[i + d][j + d] = true;
                    }
                }
            }
            step *= 2;
        }
        
        // print1(arr);
        // print2(ended);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == -1) continue;
                else if (arr[i][j] == 0) answer[0]++;
                else if (arr[i][j] == 1) answer[1]++;
            }
        }
        
        return answer;
    }
    
    public void print1(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
    
    public void print2(boolean[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
    
}