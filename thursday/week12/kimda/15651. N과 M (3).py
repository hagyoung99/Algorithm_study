n, m = map(int, input().split())
visited = [False] * n
arr = []

def solve(depth, n, m):
    if depth == m:
        print(*arr)
        return
    for i in range(n):
        visited[i] = True
        arr.append(i + 1)
        solve(depth + 1, n, m)
        visited[i] = False
        arr.pop()

solve(0, n, m)