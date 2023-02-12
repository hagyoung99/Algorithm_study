import sys

n = int(sys.stdin.readline())

graph = []
result = []
count = 0

for _ in range(n):
    lst = list(map(int, sys.stdin.readline().rstrip()))
    graph.append(lst)


def dfs(x, y):
    global count

    if x < 0 or x >= n or y < 0 or y >= n:
        return

    if graph[x][y] == 1:
        count += 1
        graph[x][y] = 0

        dfs(x-1, y)
        dfs(x+1, y)
        dfs(x, y-1)
        dfs(x, y+1)


for i in range(n):
    for j in range(n):
        if graph[i][j] == 1:
            dfs(i, j)
            result.append(count)
            count = 0


result.sort()
print(len(result))
for r in result:
    print(r)