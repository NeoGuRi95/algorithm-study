import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n][10];
        for (int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < n; i++) { // 자릿수
            for (int j = 0; j < 10; j++) { // 끝나는 수
                for (int z = 0; z <= j; z++) { // 끝나는 수가 오름차순이 되는 경우의 수(인접한 수가 같아도 오름차순)
                    dp[i][j] += dp[i - 1][z];
                }
                dp[i][j] %= 10007;
            }
        }

        int answer = 0;
        for (int i = 0; i < 10; i++) {
            answer += dp[n - 1][i];
        }

        System.out.println(answer % 10007);

        br.close();
    }
}