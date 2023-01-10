import sys

N, S = map(int, sys.stdin.readline().split())
array = list(map(int, sys.stdin.readline().split()))

subtotal = 0
end = 0
result = N + 1

for start in range(N):

    while subtotal < S and end < N:
        subtotal += array[end]
        end += 1

    if subtotal >= S and len(array[start:end]) < result:
        result = len(array[start:end])

    subtotal -= array[start]
print(result if result != N+1 else 0)
