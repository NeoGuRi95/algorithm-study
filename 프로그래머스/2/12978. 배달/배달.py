from collections import defaultdict
import heapq

INF = float('inf')

def dijkstra(N, road, start):
    graph = defaultdict(list)
    for a, b, c in road:
        graph[a].append((b, c))
        graph[b].append((a, c))
    
    distances = [INF] * (N + 1)
    
    que = []
    heapq.heappush(que, (0, start))
    distances[start] = 0
    
    while que:
        dist, now = heapq.heappop(que)
        
        if dist > distances[now]:
            continue
            
        for next, cost in graph[now]:
            if distances[next] > cost + dist:
                distances[next] = cost + dist
                heapq.heappush(que, (cost + dist, next))
    return distances

def solution(N, road, K):
    result = dijkstra(N, road, 1)
    answer = 0
    for d in result:
        if d <= K: answer += 1
    return answer