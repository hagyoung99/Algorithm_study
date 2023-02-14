import sys
sys.setrecursionlimit(10 ** 5)
input = sys.stdin.readline
TC = int(input())

def dfs(x, y):
    visited[x][y] = True
    directions = [(-1, 0), (1, 0), (0, -1), (0,1 )]
    for dx, dy in directions:
        nx = x + dx
        ny = y + dy
        if nx < 0 or nx >= n or ny <0 or ny >= m:
            continue
        if visited[nx][ny] == False and graph[nx][ny]:
            dfs(nx, ny)

for tc in range(TC):
    m, n, k = map(int, input().split())
    graph = [[0] * m for _ in range(n)]
    visited = [[False] * m for _ in range(n)]
    ans = 0

    for i in range(k):
        b, a = map(int, input().split())
        graph[a][b] = 1

    for i in range(n):
        for j in range(m):
            if visited[i][j] == False and graph[i][j]:
                dfs(i, j)
                ans += 1
    print(ans)