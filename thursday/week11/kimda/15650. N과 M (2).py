n, m = map(int, input().split())
visited = [False] * n
ans = []

def solve(depth, n, m):
    if depth == m:
        print(*ans)
        return

    for i in range(n):
        if visited[i]:
            continue
        visited[i] = True
        ans.append(i + 1)
        solve(depth + 1, n, m)
        ans.pop()

        for j in range(i + 1, n):
            visited[j] = False
solve(0, n, m)