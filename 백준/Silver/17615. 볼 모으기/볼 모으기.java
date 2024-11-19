import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String ballInfo = br.readLine();
        Stack<Character> rStack = new Stack<>();
        Stack<Character> bStack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char ball = ballInfo.charAt(i);
            rStack.add(ball);
            bStack.add(ball);
        }

        // Red count
        int rCnt = 0;
        boolean firstFlag = true;
        while (!rStack.isEmpty()) {
            char ball = rStack.pop();
           if (ball == 'B' && firstFlag) {
               firstFlag = false;
           } else if (ball == 'R' && !firstFlag) {
               rCnt++;
           }
        }

        // Blue count
        int bCnt = 0;
        firstFlag = true;
        while (!bStack.isEmpty()) {
            char ball = bStack.pop();
            if (ball == 'R' && firstFlag) {
                firstFlag = false;
            } else if (ball == 'B' && !firstFlag) {
                bCnt++;
            }
        }

        System.out.println(Math.min(rCnt, bCnt));
    }
}
