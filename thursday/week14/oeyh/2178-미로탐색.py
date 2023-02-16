import sys
from collections import deque

n, m = map(int, sys.stdin.readline().split())
graph = [list(map(int, sys.stdin.readline().rstrip())) for _ in range(n)]

visited = [[False] * m for _ in range(n)]
queue = deque()

dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]


def bfs(x, y):
    queue.append([x, y])

    while queue:
        x, y = queue.popleft()
        if x == m - 1 and y == n - 1:
            print(graph[n - 1][m - 1])
            break

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < m and 0 <= ny < n:
                if (visited[ny][nx] is False) and (graph[ny][nx] == 1):
                    graph[ny][nx] = graph[y][x] + 1
                    visited[ny][nx] = True
                    queue.append([nx, ny])


bfs(0, 0)
