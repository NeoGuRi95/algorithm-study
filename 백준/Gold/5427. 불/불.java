import java.io.*;
import java.util.*;

public class Main {
    static int w, h;
    static char[][] map;
    static Queue<Point> fireQueue = new LinkedList<>();
    static Queue<Point> personQueue = new LinkedList<>();
    static boolean successFlag;
    static int ans;
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int a = 0; a < t; a++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new char[h][w];
            successFlag = false;
            ans = 0;

            for (int i = 0; i < h; i++) {
                String row = br.readLine();
                for (int j = 0; j < w; j++) {
                    char c = row.charAt(j);
                    if (c == '*') fireQueue.offer(new Point(i, j));
                    else if (c == '@') {
                        personQueue.offer(new Point(i, j));
                        c = ',';  // 방문 표시
                    }
                    map[i][j] = c;
                }
            }

            bfs();

            if (successFlag) sb.append(ans).append('\n');
            else sb.append("IMPOSSIBLE\n");

            fireQueue.clear();
            personQueue.clear();
        }

        System.out.print(sb);
        br.close();
    }

    public static void bfs() {
        while (!personQueue.isEmpty() && !successFlag) {
            fireMove();
            personMove();
            ans++;
        }
    }

    public static void fireMove() {
        int size = fireQueue.size();
        for (int i = 0; i < size; i++) {
            Point pos = fireQueue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = pos.x + dx[d];
                int ny = pos.y + dy[d];
                if (OOB(nx, ny) || map[nx][ny] == '#' || map[nx][ny] == '*') continue;
                map[nx][ny] = '*';
                fireQueue.offer(new Point(nx, ny));
            }
        }
    }

    public static void personMove() {
        int size = personQueue.size();
        for (int i = 0; i < size; i++) {
            Point pos = personQueue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = pos.x + dx[d];
                int ny = pos.y + dy[d];
                if (OOB(nx, ny)) {
                    successFlag = true;
                    return;
                }
                if (map[nx][ny] != '.') continue;
                map[nx][ny] = ',';  // 방문 표시
                personQueue.offer(new Point(nx, ny));
            }
        }
    }

    public static boolean OOB(int x, int y) {
        return x < 0 || x >= h || y < 0 || y >= w;
    }
}