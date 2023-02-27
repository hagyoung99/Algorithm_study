import sys
from collections import deque

n = int(sys.stdin.readline())
graph = [[] for _ in range(n+1)]
visited = [False] * (n+1)
distance = [0] * (n+1)
queue = deque()
for _ in range(n-1):
    a, b, weight = map(int, sys.stdin.readline().split())
    graph[a].append([b, weight])
    graph[b].append([a, weight])

def bfs(start):
    queue.append(start)
    visited[start] = True

    while queue:
        node = queue.popleft()
        for g in graph[node]:
            if visited[g[0]] == False:
                visited[g[0]] = True
                queue.append(g[0])
                distance[g[0]] = distance[node] + g[1]

bfs(1)
result_index = distance.index(max(distance))
visited = [False] * (n + 1)
distance = [0] * (n + 1)
bfs(result_index)
print(max(distance))
