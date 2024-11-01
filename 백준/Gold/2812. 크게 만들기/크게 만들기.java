import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        char[] arr = br.readLine().toCharArray();
        Stack<Integer> stack = new Stack<>();

        int removeCnt = 0;
        for (char a : arr) {
            int num = Integer.parseInt(Character.toString(a));
            while (!stack.isEmpty() && stack.peek() < num && removeCnt < k) {
                stack.pop();
                removeCnt++;
            }
            stack.add(num);
        }

        while (removeCnt < k) {
            stack.pop();
            removeCnt++;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb.reverse());

        br.close();
    }
}
