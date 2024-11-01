import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        // init warehouse & queue
        Queue<int[]> queue = new LinkedList<>();
        int[][] warehouse = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int tomato = Integer.parseInt(st.nextToken());
                if (tomato == 1) {
                    queue.offer(new int[]{i, j});
                }
                warehouse[i][j] = tomato;
            }
        }

        // bfs
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = cur[0] + dx[d];
                    int ny = cur[1] + dy[d];
                    if (nx < 0 || nx >= n) continue;
                    if (ny < 0 || ny >= m) continue;
                    if (warehouse[nx][ny] == 0) {
                        warehouse[nx][ny] = 1;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
            ans++;
        }

        // check all tomato
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (warehouse[i][j] == 0) {
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }
        if (flag) {
            System.out.println(-1);
        } else {
            System.out.println(ans - 1);
        }

        br.close();
    }
}
