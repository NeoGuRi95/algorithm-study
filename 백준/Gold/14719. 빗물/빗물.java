import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int h = Integer.parseInt(st.nextToken());
    int w = Integer.parseInt(st.nextToken());
    int[][] matrix = new int[h][w];
    int answer = 0;

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < w; i++) {
      int blockHeight = Integer.parseInt(st.nextToken());
      for (int j = h - 1; j > h - 1 - blockHeight; j--) {
        matrix[j][i] = 1;
      }
    }

    for (int i = 0; i < h; i++) {
      Queue<Integer> que = new LinkedList<>();
      for (int j = 0; j < w; j++) {
        int block = matrix[i][j];
        if (block == 1 && que.isEmpty()) {
          que.offer(j);
        } else if (block == 1 && !que.isEmpty()) {
          que.offer(j);
          int start = que.poll();
          answer += j - start - 1;
        }
      }
    }

    System.out.println(answer);

    br.close();
  }

  public static void print(int[][] matrix, int h) {
    for (int i = 0; i < h; i++) {
      System.out.println(Arrays.toString(matrix[i]));
    }
  }
}
