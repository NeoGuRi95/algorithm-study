import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    if (n % 2 == 1) {
      System.out.println(0);
      return;
    }

    int[][] dp = new int[n + 1][3];

    dp[0][0] = 1;
    dp[1][1] = 2;

    for (int i = 2; i <= n; i++) {
      if (i % 2 == 0) { // 짝수
        dp[i][0] = dp[i - 2][2] + 3 * dp[i - 2][0];
        dp[i][2] = dp[i - 1][1];
      } else { // 홀수
        dp[i][1] = 2 * dp[i - 1][0] + dp[i - 1][2];
      }
    }

    System.out.println(dp[n][0]);

    br.close();
  }
}