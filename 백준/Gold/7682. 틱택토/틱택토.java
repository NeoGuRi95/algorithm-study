import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = br.readLine();

            if (input.equals("end")) break;

            char[] inputArr = input.toCharArray();
            char[][] game = new char[3][3];
            int inputArrIdx = 0;
            int xCnt = 0;
            int oCnt = 0;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (inputArr[inputArrIdx] == 'X') xCnt++;
                    if (inputArr[inputArrIdx] == 'O') oCnt++;
                    game[i][j] = inputArr[inputArrIdx];
                    inputArrIdx++;
                }
            }

            // x의 개수와 o의 개수의 차이가 1개 초과이거나 o의 개수가 x의 개수보다 크면 invalid
            if (Math.abs(xCnt - oCnt) > 1 || oCnt > xCnt) {
                System.out.println("invalid");
                continue;
            }

            // x가 3칸을 잇는 데 성공
            if (check(game, 'X')) {
                if (check(game, 'O')) {
                    System.out.println("invalid");
                    continue;
                }
                if (xCnt == oCnt) {
                    System.out.println("invalid");
                    continue;
                }
                if (xCnt > oCnt + 1) { // o의 개수가 x의 개수보다 1개 이상 작다면 invalid
                    System.out.println("invalid");
                    continue;
                } else {
                    System.out.println("valid");
                    continue;
                }
            }

            // o가 3칸을 잇는 데 성공
            if (check(game, 'O')) {
                if (check(game, 'X')) {
                    System.out.println("invalid");
                    continue;
                }
                if (xCnt != oCnt) { // o의 개수와 x의 개수가 같지 않다면 invalid
                    System.out.println("invalid");
                    continue;
                } else {
                    System.out.println("valid");
                    continue;
                }
            }

            // x의 개수 = 5개, o의 개수 = 4개가 아니면 invalid
            if (xCnt != 5 && oCnt != 4) {
                System.out.println("invalid");
                continue;
            }

            System.out.println("valid");
        }

        br.close();
    }

    static boolean check(char[][] game, char c) {
        for (int i = 0; i < 3; i++) {
            boolean flag = true;
            for (int j = 0; j < 3; j++) {
                if (game[i][j] != c) {
                    flag = false;
                    break;
                }
            }
            if (flag) return flag;
        }

        for (int i = 0; i < 3; i++) {
            boolean flag = true;
            for (int j = 0; j < 3; j++) {
                if (game[j][i] != c) {
                    flag = false;
                    break;
                }
            }
            if (flag) return flag;
        }

        boolean flag = true;
        for (int i = 0; i < 3; i++) {
            if (game[i][i] != c) flag = false;
        }
        if (flag) return flag;

        if (game[0][2] == c && game[1][1] == c && game[2][0] == c) return true;

        return false;
    }
}
