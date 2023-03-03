import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

n = int(input())
graph = [[] for _ in range(n + 1)]
parent = [-1] * (n + 1)

for i in range(n - 1):
    x, y = map(int, input().split())
    graph[x].append(y)
    graph[y].append(x)

def dfs(n):
    for i in graph[n]:
        if parent[i] == -1:
            parent[i] = n
            print(parent)
            dfs(i)

dfs(1)
for i in range(2, n + 1):
    print(parent[i])