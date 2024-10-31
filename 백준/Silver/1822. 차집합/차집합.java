import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int na = Integer.parseInt(st.nextToken());
        int nb = Integer.parseInt(st.nextToken());

        List<Integer> listA = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < na; i++) {
            listA.add(Integer.parseInt(st.nextToken()));
        }
        List<Integer> listB = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nb; i++) {
            listB.add(Integer.parseInt(st.nextToken()));
        }

        // sort
        Collections.sort(listA);
        Collections.sort(listB);

        // binary search
        int ans = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < na; i++) {
            int target = listA.get(i);
            if (!binarySearch(listB, target)) {
                ans++;
                sb.append(target).append(" ");
            }
        }

        System.out.println(ans);
        if (ans != 0) {
            System.out.println(sb.toString().trim());
        }

        br.close();
    }

    public static boolean binarySearch(List<Integer> list, int target) {
        int l = 0;
        int r = list.size() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (list.get(m) == target) {
                return true;
            } else if (list.get(m) > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return false;
    }
}
