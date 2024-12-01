import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int[] beltArr = new int[2 * n];
    boolean[] robotArr = new boolean[2 * n];
    int stage = 0;
    int start = 0;
    int end = n - 1;

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 2 * n; i++) {
      beltArr[i] = Integer.parseInt(st.nextToken());
    }

    while (true) {
      stage++;
      // 1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
      start = start - 1 < 0 ? 2 * n - 1 : start - 1;
      end = end - 1 < 0 ? 2 * n - 1 : end - 1;
      // 로봇이 내리는 위치에 도달하면 즉시 내린다.
      robotArr[end] = false;
//      System.out.println("start: " + start);
//      System.out.println("end: " + end);
      // 2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다.
      // 2-1. 로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
      int idx = end;
      boolean endFlag = false;
      while (true) {
        if (idx == start) endFlag = true;
        if (robotArr[idx]) {
          int ni = idx + 1 == 2 * n ? 0 : idx + 1;
          if (beltArr[ni] > 0 && !robotArr[ni]) {
            robotArr[idx] = false;
            beltArr[ni] -= 1;
            robotArr[ni] = true;
          }
          // 로봇이 내리는 위치에 도달하면 즉시 내린다.
          robotArr[end] = false;
        }
        idx = idx - 1 < 0 ? 2 * n - 1 : idx - 1;
        if (endFlag) break;
      }
//      System.out.println(Arrays.toString(beltArr));
//      System.out.println(Arrays.toString(robotArr));
//      System.out.println("-------------------");
      // 3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
      if (beltArr[start] > 0 && !robotArr[start]) {
        beltArr[start] -= 1;
        robotArr[start] = true;
      }
//      System.out.println(Arrays.toString(beltArr));
//      System.out.println(Arrays.toString(robotArr));
//      System.out.println("-------------------");
      // 4. 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
      int cnt = 0;
      for (int i = 0; i < 2 * n; i++) {
        if (beltArr[i] == 0) cnt++;
      }
      if (cnt >= k) break;
    }

    System.out.println(stage);

    br.close();
  }
}
