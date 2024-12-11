import java.io.*;
import java.util.*;

public class Main {

    static Map<Integer, Integer> graph = new HashMap<>();
    static boolean[] visited;
    static Set<Integer> keySet;
    static Set<Integer> valueSet;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        for (int key = 1; key <= n; key++) {
            int value = Integer.parseInt(br.readLine());
            graph.put(key, value);
            if (key == value) {
                set.add(value);
            }
        }

        for (int key = 1; key <= n; key++) {
            keySet = new HashSet<>();
            valueSet = new HashSet<>();
            visited = new boolean[n + 1];

            dfs(key);

            if (!isSame(keySet, valueSet)) continue;

            set.addAll(valueSet);
        }
        ;
        List<Integer> answer = new ArrayList<>(set);
        Collections.sort(answer);

        System.out.println(answer.size());
        for (int num : answer) {
            System.out.println(num);
        }

        br.close();
    }

    static void dfs(int from) {
        int to = graph.get(from);
        visited[from] = true;
        keySet.add(from);
        valueSet.add(to);
        if (!visited[to]) dfs(to);
    }

    static boolean isSame(Set<Integer> set1, Set<Integer> set2) {
        if (set1.size() != set2.size()) return false;
        for (int a : set1) {
            if (!set2.contains(a)) return false;
        }
        return true;
    }
}
