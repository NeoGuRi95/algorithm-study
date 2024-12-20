import java.io.*;
import java.util.*;

public class Main {

  static int MOD = 1000000;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String crypt = "0" + br.readLine();
    int n = crypt.length();
    char[] cryptArr = crypt.toCharArray();
    int[][] dp = new int[n][2];

    dp[0][0] = 1;
    if (cryptArr[1] == '0') {
      System.out.println(0);
      return;
    }
    dp[1][0] = 1;

    for (int i = 2; i < n; i++) {
      int concatNum = Integer.parseInt("" + cryptArr[i - 1] + cryptArr[i]);
      if (cryptArr[i] == '0') {
        if (10 <= concatNum && concatNum <= 26) {
          dp[i][1] = (dp[i - 2][0] + dp[i - 2][1]) % MOD;
        } else {
          System.out.println(0);
          return;
        }
      } else {
        dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
        if (10 <= concatNum && concatNum <= 26) {
          dp[i][1] = (dp[i - 2][0] + dp[i - 2][1]) % MOD;
        }
      }
    }

    System.out.println((dp[n - 1][0] + dp[n - 1][1]) % MOD);

    br.close();
  }
}