import sys
input = sys.stdin.readline
INF = sys.maxsize

n = int(input())
arr = list(map(int, input().split()))

arr.sort()
start, end = 0, n - 1
min = INF
ans = []

while start < end:
    s_left = arr[start]
    s_right = arr[end]
    sum = s_left + s_right
    if abs(sum) < min:
        min = abs(sum)
        ans = [s_left, s_right]
        if min == 0:
            break
    if sum < 0:
        start += 1
    else:
        end -= 1
print(ans[0], ans[1])
