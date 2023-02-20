from collections import deque

def bfs(s_a, s_b, e_a, e_b):
    q = deque()
    q.append([s_a, s_b])
    graph[s_a][s_b] = 1

    while q:
        x, y = q.popleft()
        # 종료 조건
        if x == e_a and y == e_b:
            print(graph[e_a][e_b] - 1)
            return
        # 8방향 탐색하기
        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < l and 0 <= ny < l and graph[nx][ny] == 0:
                q.append((nx, ny))
                graph[nx][ny] = graph[x][y] + 1

T = int(input())
for tc in range(T):
    l = int(input())
    s_a, s_b = map(int, input().split())
    e_a, e_b = map(int, input().split())
    graph = [[0] * l for _ in range(l)]

    dx = [1, 2, 2, 1, -1, -2, -2, -1]
    dy = [2, 1, -1, -2, -2, -1, 1, 2]
    bfs(s_a, s_b, e_a, e_b)