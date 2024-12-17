import java.io.*;
    import java.util.*;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // dp[i][0]: empty
        // dp[i][1]: 2 x 1
        // dp[i][2]: 1 x 2
        // dp[i][3]: 2 x 2
        int[][] dp = new int[n][4];
        dp[0][0] = 1;
        dp[0][1] = 1;
        dp[0][2] = 0;
        dp[0][3] = 0;

        for(int i = 1; i < n; i++) {
            dp[i][0] = (dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3]) % 10007;
            dp[i][1] = (dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3]) % 10007;
            dp[i][2] = dp[i - 1][0] % 10007;
            dp[i][3] = dp[i - 1][0] % 10007;
        }

        System.out.println((dp[n - 1][1] + dp[n - 1][2] + dp[n - 1][3]) % 10007);

        br.close();
    }
}