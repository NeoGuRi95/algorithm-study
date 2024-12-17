import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][2];

            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[j][i] = Integer.parseInt(st.nextToken());
                }
            }

            // dp[i][0]: i열의 첫번째 스티커를 떼는 경우의 최대 점수
            // dp[i][1]: i열의 두번째 스티커를 떼는 경우의 최대 점수
            // dp[i][2]: i열의 스티커를 떼지 않는 경우의 최대 점수
            int[][] dp = new int[n][3];

            dp[0][0] = arr[0][0];
            dp[0][1] = arr[0][1];
            dp[0][2] = 0;

            for (int i = 1; i < n; i++) {
                dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][2]) + arr[i][0];
                dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][2]) + arr[i][1];
                dp[i][2] = Math.max(Math.max(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]);
            }

            System.out.println(Math.max(Math.max(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]));
        }

        br.close();
    }
}