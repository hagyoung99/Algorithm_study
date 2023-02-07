n = int(input())
k = int(input())
array = [[] for _ in range(n + 1)]
visited = [False] * (n + 1)
count = 0

for _ in range(k):
    x, y = map(int, input().split())
    array[x].append(y)
    array[y].append(x)

def dfs(v):
    global count
    count += 1
    visited[v] = True
    for e in array[v]:
        if not(visited[e]):
            dfs(e)
dfs(1)
print(count - 1)