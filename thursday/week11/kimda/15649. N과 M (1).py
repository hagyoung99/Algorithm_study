n, m = map(int, input().split())
visited = [False] * n
ans = []

def solve(depth, n, m):
    if depth == m:
        print(' '.join(map(str, ans)))
        return
    for i in range(len(visited)):
        if not visited[i]:
            visited[i] = True
            ans.append(i + 1)
            solve(depth + 1, n, m)
            visited[i] = False
            ans.pop()

solve(0, n, m)


