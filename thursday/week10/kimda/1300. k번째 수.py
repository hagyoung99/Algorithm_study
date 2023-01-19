n = int(input())
k = int(input())

start, end = 1, k
ans = 0

while start <= end:
    mid = (start + end) // 2
    count = 0
    for i in range(1, n + 1):
        # mid // i => 각 i값에서 mid값보다 작거나 같은 값의 갯수를 의미
        count += min(mid // i, n)
    if count >= k:
        ans = mid
        end = mid - 1
    else:
        start = mid + 1
print(ans)