import sys
from collections import deque
v = int(sys.stdin.readline())
graph = [[] for _ in range(v+1)]
visited = [False]*(v+1)
distance = [0] * (v+1)
queue = deque()

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

for _ in range(v):
    lst = list(map(int, sys.stdin.readline().split()))
    for i in range(1, len(lst) -2, 2):
        graph[lst[0]].append([lst[i], lst[i+1]])

bfs(1)
print(max(distance))