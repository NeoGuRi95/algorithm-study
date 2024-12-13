import java.io.*;
import java.util.*;

public class Main {

  static int n;
  static List<String> answer;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int testNumber = Integer.parseInt(br.readLine());
    for (int t = 0; t < testNumber; t++) {
      answer = new ArrayList<>();
      n = Integer.parseInt(br.readLine());
      dfs(1, "1");
      Collections.sort(answer);
      for (String a : answer) {
        System.out.println(a);
      }
      System.out.println();
    }

    br.close();
  }

  static void dfs(int num, String expression) {
    if (num == n) {
      if (checkZero(expression)) {
        answer.add(expression);
      }
      return;
    }
    dfs(num + 1, expression + "+" + (num + 1));
    dfs(num + 1, expression + "-" + (num + 1));
    dfs(num + 1, expression + " " + (num + 1));
  }

  static boolean checkZero(String expression) {
    expression = expression.replaceAll(" ", "");
    StringTokenizer st = new StringTokenizer(expression, "-|+", true);
    int result = Integer.parseInt(st.nextToken());
    while (st.hasMoreTokens()) {
      String s = st.nextToken();
      if (s.equals("+")) {
        result += Integer.parseInt(st.nextToken());
      } else {
        result -= Integer.parseInt(st.nextToken());
      }
    }
    if (result == 0) {
      return true;
    } else {
      return false;
    }
  }
}
