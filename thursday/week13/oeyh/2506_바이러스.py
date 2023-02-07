import sys

sys.setrecursionlimit(10**9)
input = sys.stdin.readline
computer = int(input())
connected = int(input())
graph = [[] for _ in range(computer+1)]
visited = [0] * (computer+1)
start, count = 1, 0

for _ in range(connected):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

def dfs(r):
    global count
    visited[r] = 1

    for g in graph[r]:
        if visited[g] == 0:
            count += 1
            dfs(g)

dfs(start)
print(count)