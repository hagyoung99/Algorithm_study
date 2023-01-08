import sys

n = int(sys.stdin.readline())
array = list(map(int, sys.stdin.readline().split()))
x = int(sys.stdin.readline())

array.sort()
start, end = 0, n-1
cnt = 0

while start < end:
    sum = array[start] + array[end]

    if sum == x: cnt += 1

    if sum < x: start += 1
    else: end -= 1

print(cnt)
