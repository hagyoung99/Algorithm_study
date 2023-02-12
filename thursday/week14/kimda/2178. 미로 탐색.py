from collections import deque

n, m = map(int, input().split())
graph = [list(map(int, input())) for _ in range(n)]

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

def bfs(x, y):
    global cnt
    q = deque()
    q.append((x, y))

    while q:
        x, y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < m:
                if graph[nx][ny] == 1:
                    graph[nx][ny] = graph[x][y] + 1
                    q.append((nx, ny))
    return graph[n-1][m-1]
print(bfs(0, 0))