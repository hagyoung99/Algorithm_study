n, m = map(int, input().split())
data = list(map(int, input().split()))

start, end = 1, max(data)
res = 0
while start <= end:
    mid = (start + end) // 2
    total = 0
    for i in data:
        if i >= mid:
            total += i - mid
        else:
            continue
    if total >= m:
        res = mid
        start = mid + 1
    else:
        end = mid - 1
print(res)