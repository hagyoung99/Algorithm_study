import sys
sys.setrecursionlimit(10**9)
n, m, r = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(n+1)]
visited = [0] * (n+1)
count = 1
for _ in range(m):
    u, v = map(int, sys.stdin.readline().split())
    graph[u].append(v)
    graph[v].append(u)


def dfs(r):
    global count
    visited[r] = count
    graph[r].sort(reverse=True)

    for g in graph[r]:
        if visited[g] == 0:
            count += 1
            dfs(g)

dfs(r)

print(*visited[1:], sep="\n")
