from collections import deque

MAX = 100001
n, k = map(int, input().split())
array = [0] * MAX

def bfs():
    q = deque([n])
    while q:
        v = q.popleft()
        if v == k:
            return array[v]
        for e in (v - 1, v + 1, v * 2):
            if 0 <= e < MAX and not array[e]:
                array[e] = array[v] + 1
                q.append(e)

print(bfs())