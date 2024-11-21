import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int answer = 0; // 안전한 영역 개수
    static List<int[]> virusList = new ArrayList<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int space = Integer.parseInt(st.nextToken());
                if (space == 2)
                    virusList.add(new int[]{i, j});
                map[i][j] = space;
            }
        }

        List<int[]> walls = new ArrayList<>(); // 벽 조합
        wallDfs(walls, 0);

        System.out.println(answer);

        br.close();
    }

    public static void wallDfs(List<int[]> wallList, int start) {
        if (wallList.size() == 3) {
            for (int i = 0; i < 3; i++) { // 벽 세우기
                map[wallList.get(i)[0]][wallList.get(i)[1]] = 1;
            }
            visited = new boolean[n][m];
            for (int[] virus:virusList) {
                virusDfs(virus); // 바이러스 퍼지기
            }
            answer = Math.max(answer, countSafetySpace());
            for (int i = 0; i < 3; i++) { // 벽 제거
                map[wallList.get(i)[0]][wallList.get(i)[1]] = 0;
            }
            return;
        }
        for (int a = start; a < n*m; a++) {
            int i = a / m;
            int j = a % m;
            if (map[i][j] == 0) { // 빈 칸이어야 벽 세울 수 있음
                wallList.add(new int[]{i, j});
                wallDfs(wallList, a + 1);
                wallList.remove(wallList.size() - 1);
            }
        }
    }

    public static void virusDfs(int[] virus) {
        for (int d = 0; d < 4; d++) {
            int nx = virus[0] + dx[d];
            int ny = virus[1] + dy[d];
            if (OOB(new int[] {nx, ny})) continue;
            if (map[nx][ny] == 1 || map[nx][ny] == 2) continue;
            if (visited[nx][ny]) continue;
            visited[nx][ny] = true;
            virusDfs(new int[] {nx, ny});
        }
    }

    public static boolean OOB(int[] pos) {
        if (pos[0] < 0 || pos[0] >= n) return true;
        if (pos[1] < 0 || pos[1] >= m) return true;
        return false;
    }

    public static int countSafetySpace() {
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0 && !visited[i][j]) result++;
            }
        }
        return result;
    }
}
