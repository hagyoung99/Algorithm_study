import sys
sys.setrecursionlimit(10000)


def dfs(x, y):
    if (0 <= x < m) and (0 <= y < n):
        if graph[y][x] == 1:
            graph[y][x] = 0

            dfs((x+1), y)
            dfs((x-1), y)
            dfs(x, (y-1))
            dfs(x, (y+1))
    else:
        return

t = int(sys.stdin.readline())
for _ in range(t):
    m, n, k = map(int, input().split())
    graph = [[0] * m for _ in range(n)]
    count = 0

    for _ in range(k):
        x, y = map(int, input().split())
        graph[y][x] = 1

    for y in range(n):
        for x in range(m):
            if graph[y][x] == 1:
                count += 1
                dfs(x, y)
    print(count)
