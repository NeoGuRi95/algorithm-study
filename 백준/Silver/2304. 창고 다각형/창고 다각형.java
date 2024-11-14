import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] pillarList = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            pillarList[i][0] = l;
            pillarList[i][1] = h;
        }
        Arrays.sort(pillarList, Comparator.comparingInt(arr -> arr[0]));

        Stack<int[]> leftStack = new Stack<>();
        Stack<int[]> rightStack = new Stack<>();
        for (int i = 0; i < n; i++) {
            leftStack.add(pillarList[i]);
        }

        int answer = 0;
        int maxL = 0;
        int maxH = 0;
        while (!leftStack.isEmpty()) {
            int[] pillar = leftStack.pop();
            if (rightStack.isEmpty()) {
                rightStack.add(pillar);
                maxL = pillar[0];
                maxH = pillar[1];
            } else if (pillar[1] < maxH) {
                rightStack.add(pillar);
            } else {
                rightStack.add(pillar);
                int area = (maxL - pillar[0]) * maxH;
                answer += area;
                maxL = pillar[0];
                maxH = pillar[1];
            }
        }
//        System.out.println("mid answer: " + answer);

        int[] firstPillar = rightStack.pop();
        maxL = firstPillar[0];
        maxH = firstPillar[1];
        while (!rightStack.isEmpty()) {
            int[] pillar = rightStack.pop();
            if (pillar[1] > maxH) {
                int area = (pillar[0] - maxL) * maxH;
                answer += area;
                maxL = pillar[0];
                maxH = pillar[1];
            }
        }
        answer += maxH;

        System.out.println(answer);

        br.close();
    }
}
