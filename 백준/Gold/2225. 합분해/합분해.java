import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int[][] dp = new int[k + 1][n + 1];
    for (int j = 0; j <= n; j++) {
      dp[1][j] = 1;
    }
    for (int i = 0; i <= k; i++) {
      dp[i][0] = 1;
    }

    for (int i = 2; i <= k; i++) {
      for (int j = 1; j <= n; j++) {
        for (int z = 0; z <= j; z++) {
          dp[i][j] += dp[i - 1][z];
          dp[i][j] = dp[i][j] % 1000000000;
        }
      }
    }

    System.out.println(dp[k][n]);


    br.close();
  }
}