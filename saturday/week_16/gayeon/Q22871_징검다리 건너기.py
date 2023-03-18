import sys
input = sys.stdin.readline

n = int(input())
stone = [0] + list(map(int, input().split()))
s, e, r = 1, (n-1) * (1 + abs(stone[n] - stone[1])), 0

while s <= e:
    m = (s + e) // 2
    flag = 0
    stack = [1]
    v = [False]*(n+1)
    v[1] = True
    
    while stack:
        k = stack.pop()

        if k == n:
            flag = 1
            break

        for i in range(k + 1, n + 1):
            p = (i - k) * (1 + abs(stone[i] - stone[k]))
            if p <= m and not v[i]:
                stack.append(i)
                v[i] = True

    if flag:
        e = m - 1
        r = m
    else:
        s = m + 1

print(r)