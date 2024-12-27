import java.util.*;

class Solution {
    
    int[] parent;
    
    public int solution(int n, int[][] costs) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        
        for (int[] cost:costs) {
            pq.offer(cost);
        }
        
        this.parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int answer = 0;
        
        while (!pq.isEmpty()) {
            int[] cost = pq.poll();
            // System.out.println("cost: " + cost[2]);
            
            if (find(cost[0]) == find(cost[1])) continue;
            
            merge(cost[0], cost[1]);
            System.out.println(Arrays.toString(parent));
            
            answer += cost[2];
        }
        
        return answer;
    }
    
    public int find(int i) {
        if (parent[i] == i) return i;
        return find(parent[i]);
    }
    
    public void merge(int i, int j) {
        int pi = find(i);
        int pj = find(j);
        if (pi < pj) this.parent[pj] = pi;
        else this.parent[pi] = pj;
    }
}