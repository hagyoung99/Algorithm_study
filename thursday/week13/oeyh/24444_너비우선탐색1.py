import sys
from collections import deque
sys.setrecursionlimit(10**9)
n, m, r = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(n+1)]
visited = [0]*(n+1)
queue = deque()

count = 1
for _ in range(m):
    u, v = map(int, sys.stdin.readline().split())
    graph[u].append(v)
    graph[v].append(u)

def bfs(r):
    global count
    visited[r] = count
    queue.append(r)

    while queue:
        node = queue.popleft()
        graph[node].sort()
        for g in graph[node]:
            if visited[g] == 0:
                count += 1
                visited[g] = count
                queue.append(g)


bfs(r)
print(*visited[1:], sep="\n")
