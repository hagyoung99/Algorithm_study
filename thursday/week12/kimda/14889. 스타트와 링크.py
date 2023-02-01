import sys
input = sys.stdin.readline

def dfs(index):
    global minAns
    if index == n // 2:
        startSum = 0
        linkSum = 0
        for i in range(0, n):
            if i not in start:
                link.append(i)
        for i in range(0, n // 2 - 1):
            for j in range(i + 1, n // 2):
                startSum += data[start[i]][start[j]] + data[start[j]][start[i]]
                linkSum += data[link[i]][link[j]] + data[link[j]][link[i]]
        diff = abs(linkSum - startSum)
        if minAns > diff:
            minAns = diff
        link.clear()
        return

    for i in range(n):
        if i in start:
            continue
        if len(start) > 0 and start[len(start) - 1] > i:
            continue
        start.append(i)
        dfs(index + 1)
        start.pop()

n = int(input())
data = [list(map(int, input().split())) for _ in range(n)]
ans = []
start = []
link = []

minAns = float('INF')
dfs(0)
print(minAns)