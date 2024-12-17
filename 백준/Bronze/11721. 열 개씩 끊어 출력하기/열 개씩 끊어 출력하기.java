import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        char[] charArr = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charArr.length; i++) {
            sb.append(charArr[i]);
            if (i % 10 == 9 && i != charArr.length - 1) sb.append('\n');
        }

        System.out.println(sb);

        br.close();
    }
}