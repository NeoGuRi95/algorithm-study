import java.io.*;
import java.util.*;

public class Main {

    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        int[][] answer = new int[n][m];
        Queue<Position> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                matrix[i][j] = num;
                if (num == 2) {
                    queue.add(new Position(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        while (!queue.isEmpty()) {
            Position pos = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = pos.x + dx[d];
                int ny = pos.y + dy[d];
                if (OOB(nx, ny)) continue;
                if (visited[nx][ny]) continue;
                if (matrix[nx][ny] == 0) continue;
                queue.add(new Position(nx, ny, pos.depth + 1));
                visited[nx][ny] = true;
                answer[nx][ny] = pos.depth + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1 && answer[i][j] == 0) {
                    answer[i][j] = -1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static boolean OOB(int x, int y) {
        if (x < 0 || x >= n) return true;
        if (y < 0 || y >= m) return true;
        return false;
    }

    static class Position {
        int x;
        int y;
        int depth;
        public Position(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
}
