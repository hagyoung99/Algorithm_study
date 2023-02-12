import sys
from collections import deque
sys.setrecursionlimit(10**9)
n, m, v = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(n+1)]
dfs_visited = [0] * (n+1)
bfs_visited = [0] * (n+1)
dfs_result = []
bfs_result = []

dcnt = 1
bcnt = 1

queue = deque()

for _ in range(m):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)


def dfs(r):
    dfs_visited[r] = 1
    print(r, end=" ")
    graph[r].sort()

    for g in graph[r]:
        if dfs_visited[g] == 0:
            dfs(g)

def bfs(r):
    bfs_visited[r] = 1
    queue.append(r)

    while queue:
        node = queue.popleft()
        print(node, end=" ")
        graph[node].sort()

        for g in graph[node]:
            if bfs_visited[g] == 0:
                bfs_visited[g] = 1
                queue.append(g)

dfs(v)
print()
bfs(v)
