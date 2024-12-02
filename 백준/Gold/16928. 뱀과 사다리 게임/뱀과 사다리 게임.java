import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    Map<Integer, Integer> sadari = new HashMap<>();
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      sadari.put(x, y);
    }
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      sadari.put(u, v);
    }

    int[] board = new int[101];
    for (int i = 2; i < 101; i++) {
      board[i] = Integer.MAX_VALUE;
    }
    Queue<Integer> que = new LinkedList<>();
    que.offer(1);
    while (!que.isEmpty()) {
      int cur = que.poll();
      int curRollCnt = board[cur];
      // 주사위 굴리기
      for (int i = 1; i <= 6; i++) {
        int rollDest = cur + i;
        if (rollDest > 100) continue;
        if (sadari.containsKey(cur)) {
          int sadariDest = sadari.get(cur);
          if (curRollCnt < board[sadariDest]) {
            board[sadariDest] = curRollCnt;
            que.offer(sadariDest);
          }
          continue;
        }
        if (curRollCnt + 1 < board[rollDest]) {
          board[rollDest] = curRollCnt + 1;
          que.add(rollDest);
        }
      }
    }

    System.out.println(board[100]);

    br.close();
  }
}
