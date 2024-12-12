import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] liquidArr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            liquidArr[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0;
        int r = n - 1;
        int minDiff = Integer.MAX_VALUE;
        int[] answer = new int[2];
        while (l < r) {
            int leftLiquid = liquidArr[l];
            int rightLiquid = liquidArr[r];
            int diff = Math.abs(leftLiquid + rightLiquid);
            if (diff < minDiff) {
                minDiff = diff;
                answer[0] = leftLiquid;
                answer[1] = rightLiquid;
            }

            if (leftLiquid + rightLiquid < 0) {
                l++;
            } else {
                r--;
            }
        }

        System.out.println(answer[0] + " " + answer[1]);

        br.close();
    }
}
