import sys
import heapq

input = sys.stdin.readline
N = int(input())

HEAP = []

for _ in range(N):
    n = int(input())

    if n != 0:
        heapq.heappush(HEAP, (abs(n), n))
    else:
        smallest = 0
        if len(HEAP) > 0:
            smallest = heapq.heappop(HEAP)[1]
        print(smallest)
