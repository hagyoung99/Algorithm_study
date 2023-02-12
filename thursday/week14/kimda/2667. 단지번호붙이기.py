n = int(input())
data = [list(map(int, input())) for _ in range(n)]
visited = [[False] * n for _ in range(n)]
ans = []
cnt = 0

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

def dfs(x, y):
    global cnt
    visited[x][y] = True
    if data[x][y] == 1:
        cnt += 1
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < n and 0 <= ny < n:
            if data[nx][ny] == 1 and visited[nx][ny] == False:
                dfs(nx, ny)

for i in range(n):
    for j in range(n):
        if data[i][j] == 1 and visited[i][j] == False:
            dfs(i, j)
            ans.append(cnt)
            cnt = 0

ans.sort()
print(len(ans))
for i in ans:
    print(i)