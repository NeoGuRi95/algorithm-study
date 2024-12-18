import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[] dp = new int[n + 1];
    for (int i = 2; i < n + 1; i++) {
      dp[i] = Integer.MAX_VALUE;
    }

    dp[1] = 1;
    for (int i = 2; i < n + 1; i++) {
      int maxSqrt = (int) Math.sqrt(i);
      for (int j = 1; j <= maxSqrt; j++) {
        int pow = (int) Math.pow(j, 2);
        dp[i] = Math.min(dp[i - pow] + 1, dp[i]);
      }
    }

    System.out.println(dp[n]);

    br.close();
  }
}