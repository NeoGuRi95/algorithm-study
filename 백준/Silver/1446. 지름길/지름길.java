import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        Map<Integer, List<int[]>> info = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            if (info.containsKey(start)) {
                info.get(start).add(new int[] {end, cost});
            } else {
                info.put(start, new ArrayList<>());
                info.get(start).add(new int[] {end, cost});
            }
        }

        int[] dp = new int[10000];
        for (int i = 0; i <= d; i++) {
            dp[i] = i;
        }

        for (int i = 0; i <= d; i++) {
            if (i > 0) dp[i] = Math.min(dp[i - 1] + 1, dp[i]);
            if (info.containsKey(i)) { // 지름길 존재
                List<int[]> endList = info.get(i);
                for (int[] end:endList) {
                    dp[end[0]] = Math.min(dp[end[0]], dp[i] + end[1]);
                }
            }
        }

        System.out.println(dp[d]);
    }
}
