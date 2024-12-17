import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[n + 1];
        dp[0] = 1; // 1
        dp[1] = 1; // 10
        // 3자리: 100 101
        // 4자리: 1001 1000 1010
        // 5자리: 10010 10000 10100 10001 10101
        // 6자리: 100100 100000 101000 100010 101010 100101 100001 101001
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[n - 1]);

        br.close();
    }
}