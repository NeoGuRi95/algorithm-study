import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0, l = 0, r = 0;
        Map<Integer, Integer> info = new HashMap<>();
        while (true) {
            int rightNum = arr[r];
            if (info.getOrDefault(rightNum, -1) == k) {
                while (info.get(rightNum) == k) {
                    int leftNum = arr[l];
                    info.put(leftNum, info.get(leftNum) - 1);
                    l++;
                }
            }
            info.put(rightNum, info.getOrDefault(rightNum, 0) + 1);
            answer = Math.max(answer, r - l + 1);
            r++;
            if (r == n) break;
        }

        System.out.println(answer);

        br.close();
    }
}
