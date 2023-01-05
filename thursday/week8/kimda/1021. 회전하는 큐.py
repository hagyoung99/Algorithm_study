from collections import deque
n, m = map(int, input().split())
nums = list(map(int,input().split()) )
q = deque()
for i in range(1, n + 1):
    q.append(i)
ans = 0
for i in nums:
    while True:
        if i == q[0]:
            q.popleft()
            break
        else:
            if q.index(i) >= len(q) / 2:
                while q[0] != i:
                    q.appendleft(q.pop())
                    ans += 1
            else:
                while q[0] != i:
                    q.append(q.popleft())
                    ans += 1
print(ans)