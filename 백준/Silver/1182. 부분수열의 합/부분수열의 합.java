import java.util.*;
import java.io.*;

public class Main {

  private static int n;
  private static int s;
  private static final List<Integer> numList = new ArrayList<>();;
  private static int ans = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    s = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      numList.add(Integer.parseInt(st.nextToken()));
    }
//    Collections.sort(numList);

    for (int i = 0; i < n; i++) {
      dfs(i, numList.get(i));
    }

    bw.write("" + ans);

    br.close();
    bw.flush();
    bw.close();
  }

  public static void dfs(int startIdx, int acc) {
    if (acc == s) ans++;
    for (int i = startIdx + 1; i < n; i++) {
//      if (acc + numList.get(i) > s) break;
      acc += numList.get(i);
      dfs(i, acc);
      acc -= numList.get(i);
    }
  }
}
