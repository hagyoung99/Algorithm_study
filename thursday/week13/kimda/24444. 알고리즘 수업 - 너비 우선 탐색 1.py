import sys
from collections import deque
input = sys.stdin.readline

n, m, r = map(int, input().split())
graph = [[] for _ in range(n + 1)]
visited = [0] * (n + 1)
cnt = 1
# 간선 정보 입력
for i in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
# graph => [[], [4, 2], [1, 3, 4], [2, 4], [1, 2, 3], []]

def bfs(v):
    global cnt
    queue = deque([r])
    visited[r] = cnt
    while queue:
        v = queue.popleft()
        graph[v].sort()
        for i in graph[v]:
            if visited[i] == 0:
                cnt += 1
                visited[i] = cnt
                queue.append(i)

bfs(r)
for i in range(1, n + 1):
    print(visited[i])