import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))
m = int(input())
arr.sort()
count = 0
sum = 0
start, end = 0, n - 1

while start < end:
    sum = arr[start] + arr[end]
    if sum == m:
        count += 1
    if sum < m:
        start += 1
        continue
    end -= 1

print(count)