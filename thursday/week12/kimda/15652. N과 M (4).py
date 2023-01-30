n, m = map(int, input().split())
arr = []

def solve(depth, index, n, m):
    if depth == m:
        print(*arr)
        return
    for i in range(index, n + 1):
        arr.append(i)
        solve(depth + 1, i, n, m)
        arr.pop()

solve(0, 1, n, m)