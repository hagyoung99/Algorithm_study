import sys

N = int(sys.stdin.readline())
array = list(map(int, sys.stdin.readline().split()))

array.sort()
start, end = 0, N-1
neutral = 2e9 + 1

while start < end:
    subtotal = array[start] + array[end]

    if abs(subtotal) < neutral:
        neutral = abs(subtotal)
        result = [array[start], array[end]]
        if neutral == 0:
            break
    if subtotal < 0:
        start += 1
    else:
        end -= 1

print(result[0], result[1])

