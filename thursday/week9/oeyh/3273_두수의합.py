import sys

n = int(sys.stdin.readline())
array = list(map(int, sys.stdin.readline().split()))
x = int(sys.stdin.readline())

start, end = 0, n-1
cnt = 0

while start < end:
    subtotal = array[start] + array[end]

    if subtotal == x:
        cnt += 1
        start += 1
    if subtotal < x:
        start += 1
    else:
        end -= 1

print(cnt)
