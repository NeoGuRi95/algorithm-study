import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int[] dp = new int[n];
    dp[0] = arr[0];
    for (int i = 1; i < n; i++) {
      dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
    }

    int answer = -1001;
    for (int i = 0; i < n; i++) {
      answer = Math.max(dp[i], answer);
    }

    System.out.println(answer);

    br.close();
  }
}