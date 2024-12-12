import java.io.*;
import java.util.*;

public class Main {

    static int n, k, p, x;
    static int[][] display = {
        {1, 1, 1, 0, 1, 1, 1}, // 0
        {0, 0, 1, 0, 0, 1, 0}, // 1
        {1, 0, 1, 1, 1, 0, 1}, // 2
        {1, 0, 1, 1, 0, 1, 1}, // 3
        {0, 1, 1, 1, 0, 1, 0}, // 4
        {1, 1, 0, 1, 0, 1, 1}, // 5
        {1, 1, 0, 1, 1, 1, 1}, // 6
        {1, 0, 1, 0, 0, 1, 0}, // 7
        {1, 1, 1, 1, 1, 1, 1}, // 8
        {1, 1, 1, 1, 0, 1, 1}, // 9
    };
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // n 층까지 이용 가능
        k = Integer.parseInt(st.nextToken()); // K 자리의 디스플레이
        p = Integer.parseInt(st.nextToken()); // 최소 1개, 최대 p개의 디스플레이 반전 가능
        x = Integer.parseInt(st.nextToken()); // 현재 엘리베이터는 x 층

        int[] from = convertDigit(x, k);
        for (int i = 1; i <= n; i++) { // 1 ~ n 층까지 순회하며 해당 층으로 변환 가능한지 확인
            if (i == x) continue;
            int[] target = convertDigit(i, k);
            checkReverse(from, target);
        }

        System.out.println(count);

        br.close();
    }

    public static void checkReverse(int[] from, int[] target) {
        int reverseCnt = 0;
        for (int i = 0; i < k; i++) {
            int[] fromDigitArr = display[from[i]];
            int[] targetDigitArr = display[target[i]];
            for (int idx = 0; idx < 7; idx++) {
                if (fromDigitArr[idx] != targetDigitArr[idx]) reverseCnt++;
                if (reverseCnt > p) return;
            }
        }
        count++;
    }

    public static int[] convertDigit(int floor, int k) {
        int[] result = new int[k];
        for (int i = 1; i <= k; i++) {
            result[k - i] = floor % 10;
            floor /= 10;
        }
        return result;
    }
}
