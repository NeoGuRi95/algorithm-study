import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < roads.length; i++) {
            int[] road = roads[i];
            List<Integer> toList1 = graph.getOrDefault(road[0], new ArrayList<>());
            List<Integer> toList2 = graph.getOrDefault(road[1], new ArrayList<>());
            toList1.add(road[1]);
            toList2.add(road[0]);
            graph.put(road[0], toList1);
            graph.put(road[1], toList2);
        }
        
        int[] distances = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Queue<int[]> que = new LinkedList<>();

        visited[destination] = true;
        que.offer(new int[] {destination, 0});

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            for (int next:graph.get(cur[0])) {
                if (visited[next]) continue;
                visited[next] = true;
                distances[next] = cur[1] + 1;
                que.offer(new int[] {next, cur[1] + 1});
            }
        }
        
        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            int s = sources[i];
            if (visited[s]) answer[i] = distances[s];
            else answer[i] = -1;
        }
        
        return answer;
    }
}