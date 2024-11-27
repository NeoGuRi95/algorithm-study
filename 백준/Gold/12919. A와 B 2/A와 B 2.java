import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String t = br.readLine();
        int answer = 0;

        Set<String> visited = new HashSet<>();
        Queue<String> que = new LinkedList<>();

        visited.add(t);
        que.offer(t);
        while (!que.isEmpty()) {
            String now = que.poll();
            visited.add(now);
            if (now.equals(s)) {
                answer = 1;
                break;
            }
            if (now.length() > s.length()) {
                // 마지막 문자가 A인 경우
                if (now.charAt(now.length() - 1) == 'A') {
                    String addA = now.substring(0, now.length() - 1);
                    if (!visited.contains(addA)) {
                        que.offer(addA);
                    }
                }
                // 첫번째 문자가 B인 경우
                if (now.charAt(0) == 'B') {
                    String addB = now.substring(1);
                    String reverseAddB = (new StringBuilder(addB)).reverse().toString();
                    if (!visited.contains(reverseAddB)) {
                        que.offer(reverseAddB);
                    }
                }
            }
        }

        System.out.println(answer);
        br.close();
    }
}
