import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int answer = Integer.MAX_VALUE;

        Queue<Position> que = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        que.offer(new Position(n, 0));
        
        while (!que.isEmpty()) {
            Position curPosition = que.poll();
            int curSecond = curPosition.second;
            int curX = curPosition.x;
            visited[curX] = true;
            if (curX == k) {
                answer = Math.min(answer, curSecond);
                continue;
            }
            if (curX * 2 <= 100000 && !visited[curX * 2]) {
                que.offer(new Position(curX * 2, curSecond));
            }
            if (curX + 1 <= 100000 && !visited[curX + 1]) {
                que.offer(new Position(curX + 1, curSecond + 1));
            }
            if (curX - 1 >= 0 && !visited[curX - 1]) {
                que.offer(new Position(curX - 1, curSecond + 1));
            }
        }

        System.out.println(answer);

        br.close();
    }

    static class Position {
        int x;
        int second;
        Position(int x, int second) {
            this.x = x;
            this.second = second;
        }
    }
}
