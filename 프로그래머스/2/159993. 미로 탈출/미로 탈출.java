import java.util.*;

class Solution {
    
    int[] dx = new int[] {1, -1, 0, 0};
    int[] dy = new int[] {0, 0, 1, -1};
    int n, m;
    char[][] miro;
    boolean[][] visited;
    
    public int solution(String[] maps) {
        int[] sPos = new int[2];
        int[] ePos = new int[2];
        int[] lPos = new int[2];
        n = maps.length;
        m = maps[0].length();
        miro = new char[n][m];
        
        for (int i = 0; i < n; i++) {
            miro[i] = maps[i].toCharArray();
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char cur = miro[i][j];
                if (cur == 'S') {
                    sPos[0] = i;
                    sPos[1] = j;
                }
                else if (cur == 'E') {
                    ePos[0] = i;
                    ePos[1] = j;
                }
                else if (cur == 'L') {
                    lPos[0] = i;
                    lPos[1] = j;
                } 
            }
        }
        
        visited = new boolean[n][m];
        int lavorDistance = bfs(sPos, lPos);
        if (lavorDistance == 0) return -1;
        
        visited = new boolean[n][m];
        int exitDistance = bfs(lPos, ePos);
        if (exitDistance == 0) return -1;
        
        return lavorDistance + exitDistance;
    }
    
    int bfs(int[] start, int[] end) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {start[0], start[1], 0});
        visited[start[0]][start[1]] = true;
        
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            if (cur[0] == end[0] && cur[1] == end[1]) return cur[2];
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if (OOB(nx, ny)) continue;
                if (visited[nx][ny]) continue;
                if (miro[nx][ny] == 'X') continue;
                visited[nx][ny] = true;
                que.offer(new int[] {nx, ny, cur[2] + 1});
            }
        }
        
        return 0;
    }
    
    boolean OOB(int x, int y) {
        if (x < 0 || x >= n) return true;
        else if (y < 0 || y >= m) return true;
        return false;
    }
}