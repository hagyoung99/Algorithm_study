import sys
from collections import deque
sys.setrecursionlimit(100000)
n = int(sys.stdin.readline())
graph = [[] for _ in range(n+1)]
result = [0] * (n+1)
answer = [0] * (n+1)
queue = deque()

def dfs(r):
    for g in graph[r]:
        if result[g] == 0:
            result[g] = r
            dfs(g)

def bfs(r):
    queue.append(r)
    while queue:
        node = queue.popleft()
        for g in graph[node]:
            if answer[g] == 0:
                answer[g] = node
                queue.append(g)

for _ in range(n-1):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)

dfs(1)
bfs(1)
print(*result[2:])
print(*answer[2:])
