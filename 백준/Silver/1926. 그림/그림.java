import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        Queue<List<Integer>> que = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int cnt = 0;
        int maxDepth = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && matrix[i][j] == 1) {
                    int depth = 0;
                    cnt++;
                    que.add(Arrays.asList(i, j));
                    while (que.size() > 0) {
                        List<Integer> cur = que.poll();
                        int x = cur.get(0);
                        int y = cur.get(1);
                        if (visited[x][y]) continue;
                        depth++;
                        visited[x][y] = true;
                        for (int d = 0; d < 4; d++) {
                            int nx = x + dx[d];
                            int ny = y + dy[d];
                            if (OOB(nx, ny)) continue;
                            if (!visited[nx][ny] && matrix[nx][ny] == 1) {
                                que.add(Arrays.asList(nx, ny));
                            }
                        }
                    }
                    maxDepth = Math.max(maxDepth, depth);
                }
            }
        }

        System.out.println(cnt);
        System.out.println(maxDepth);

        br.close();
    }

    public static boolean OOB(int x, int y) {
        if (x < 0 || x >= n) {
            return true;
        }
        if (y < 0 || y >= m) {
            return true;
        }
        return false;
    }
}
