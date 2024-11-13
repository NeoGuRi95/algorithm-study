import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Character> list = new LinkedList<>();
        for (char c : br.readLine().toCharArray()) {
            list.add(c);
        }

        ListIterator<Character> iter = list.listIterator(list.size());
        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "L":
                    if (iter.hasPrevious()) {
                        iter.previous();
                    }
                    break;
                case "D":
                    if (iter.hasNext()) {
                        iter.next();
                    }
                    break;
                case "B":
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                    break;
                case "P":
                    char c = st.nextToken().charAt(0);
                    iter.add(c);
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c:list) {
            sb.append(c);
        }

        System.out.println(sb);

        br.close();
    }
}
