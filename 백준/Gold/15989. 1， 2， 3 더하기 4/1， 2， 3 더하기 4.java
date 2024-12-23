import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[10001][2];

        dp[1][0] = 1; // 1
        dp[1][1] = 0;

        dp[2][0] = 1; // 1+1
        dp[2][1] = 1; // 2

        dp[3][0] = 2; // 1+1+1, 2+1
        dp[3][1] = 1; // 3

//        dp[4][0] = 3; // 1+1+1+1, 2+1+1, 3+1
//        dp[4][1] = 1; // 2+2
//
//        dp[5][0] = 4; // 1+1+1+1+1, 2+1+1+1, 3+1+1, 2+2+1
//        dp[5][1] = 1; // 3+2
//
//        dp[6][0] = 5; // 1+1+1+1+1+1, 2+1+1+1+1, 3+1+1+1, 2+2+1+1, 3+2+1
//        dp[6][1] = 2; // 2+2+2, 3+3
//
//        dp[7][0] = 7; // 1+1+1+1+1+1+1, 2+1+1+1+1+1, 3+1+1+1+1, 2+2+1+1+1, 3+2+1+1, 3+3+1, 2+2+2+1
//        dp[7][1] = 1; // 3+2+2
//
//        dp[8][0] = 8; // 1+1+1+1+1+1+1+1, 2+1+1+1+1+1+1, 3+1+1+1+1+1, 2+2+1+1+1+1, 3+2+1+1+1, 3+3+1+1, 2+2+2+1+1, 3+2+2+1
//        dp[8][1] = 2; // 2+2+2+2, 3+3+2
//
//        dp[9][0] = 10; // 1+1+1+1+1+1+1+1+1, 2+1+1+1+1+1+1+1, 3+1+1+1+1+1+1, 2+2+1+1+1+1+1, 3+2+1+1+1+1, 3+3+1+1+1, 2+2+2+1+1+1, 3+2+2+1+1, 2+2+2+2+1, 3+3+2+1
//        dp[9][1] = 2; // 2+2+2+3, 3+3+3
//
//        dp[10][0] = 12; // 1+1+1+1+1+1+1+1+1+1, 2+1+1+1+1+1+1+1+1, 3+1+1+1+1+1+1+1, 2+2+1+1+1+1+1+1, 3+2+1+1+1+1+1, 3+3+1+1+1+1, 2+2+2+1+1+1+1, 3+2+2+1+1+1, 2+2+2+2+1+1, 3+3+2+1+1, 2+2+2+3+1, 3+3+3+1
//        dp[10][1] = 2; // 2+2+2+2+2, 3+3+2+2
//
//        dp[11][0] = 14; // ...
//        dp[11][1] = 2; // 2+2+2+3+2, 3+3+3+2
//
//        dp[12][0] = 16; // ...
//        dp[12][1] = 3; // 2+2+2+2+2+2, 2+2+2+3+3, 2+3+3+3
//
//        dp[18][1] = 4;// 2*9, 2*6, 2*3, 2*0

        int d = 1;
        for (int i = 4; i < 10001; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            if (i % 6 == 0) {
                d++;
                dp[i][1] = d;
            } else {
                dp[i][1] = Math.max(dp[i - 2][1], dp[i - 3][1]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int a = 0; a < n; a++) {
            int idx = Integer.parseInt(br.readLine());
            sb.append(dp[idx][0] + dp[idx][1]).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}
