import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // vertex
        int m = Integer.parseInt(st.nextToken()); // edge
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Node(end, cost));
            graph.get(end).add(new Node(start, cost));
        }

        int[] d = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            d[i] = Integer.MAX_VALUE;
        }
        d[1] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        pq.offer(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (d[cur.idx] < cur.cost) continue;

            List<Node> nextNodeList = graph.get(cur.idx);
            for (int i = 0; i < nextNodeList.size(); i++) {
                Node nextNode = nextNodeList.get(i);
                int newDistance = cur.cost + nextNode.cost;
                if (d[nextNode.idx] > newDistance) {
                    d[nextNode.idx] = newDistance;
                    pq.offer(new Node(nextNode.idx, newDistance));
                }
            }
        }

        System.out.println(d[n]);

        br.close();
    }

    static class Node {
        int idx, cost;

        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
}
