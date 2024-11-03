import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        int[] arr = new int[t];
        int max = 0;
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            arr[i] = n;
            max = Math.max(n, max);
        }

        // dp[i][0] : 0 출력 횟수
        // dp[i][1] : 1 출력 횟수
        int[][] dp = new int[max + 1][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        if (max > 0) {
            dp[1][0] = 0;
            dp[1][1] = 1;
        }
        for (int i = 2; i <= max; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }

        StringBuilder sb;
        for (int i = 0; i < t; i++) {
            sb = new StringBuilder();
            sb.append(dp[arr[i]][0]);
            sb.append(" ");
            sb.append(dp[arr[i]][1]);
            sb.append("\n");
            bw.write(sb.toString());
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
