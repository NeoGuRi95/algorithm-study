import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[][] dp = new long[n][10];
        // 초기값
        dp[0][0] = 0;
        for (int i = 1; i < 10; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                if (j - 1 >= 0) {
                    dp[i][j - 1] += dp[i - 1][j];
                    dp[i][j - 1] %= 1000000000;
                }
                if (j + 1 < 10) {
                    dp[i][j + 1] += dp[i - 1][j];
                    dp[i][j + 1] %= 1000000000;
                }
            }
        }

        long ans = 0;
        for (int j = 0; j < 10; j++) {
            ans += dp[n - 1][j];
        }
        System.out.println(ans % 1000000000);

        br.close();
    }
}
