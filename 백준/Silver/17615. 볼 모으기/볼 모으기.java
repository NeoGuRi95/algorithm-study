import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String ballInfo = br.readLine();
        Stack<Character> rStack = new Stack<>();
        Stack<Character> bStack = new Stack<>();
        Queue<Character> rQueue = new LinkedList<>();
        Queue<Character> bQueue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char ball = ballInfo.charAt(i);
            rStack.add(ball);
            bStack.add(ball);
            rQueue.add(ball);
            bQueue.add(ball);
        }

        // Red stack count
        int rStackCnt = 0;
        boolean firstFlag = true;
        while (!rStack.isEmpty()) {
            char ball = rStack.pop();
           if (ball == 'B' && firstFlag) {
               firstFlag = false;
           } else if (ball == 'R' && !firstFlag) {
               rStackCnt++;
           }
        }

        // Blue stack count
        int bStackCnt = 0;
        firstFlag = true;
        while (!bStack.isEmpty()) {
            char ball = bStack.pop();
            if (ball == 'R' && firstFlag) {
                firstFlag = false;
            } else if (ball == 'B' && !firstFlag) {
                bStackCnt++;
            }
        }

        // Red Queue count
        int rQueueCnt = 0;
        firstFlag = true;
        while (!rQueue.isEmpty()) {
            char ball = rQueue.poll();
            if (ball == 'B' && firstFlag) {
                firstFlag = false;
            } else if (ball == 'R' && !firstFlag) {
                rQueueCnt++;
            }
        }

        // Red Queue count
        int bQueueCnt = 0;
        firstFlag = true;
        while (!bQueue.isEmpty()) {
            char ball = bQueue.poll();
            if (ball == 'R' && firstFlag) {
                firstFlag = false;
            } else if (ball == 'B' && !firstFlag) {
                bQueueCnt++;
            }
        }

        System.out.println(Math.min(Math.min(rStackCnt, bStackCnt), Math.min(rQueueCnt, bQueueCnt)));
    }
}
