import heapq
import sys
input = sys.stdin.readline

N = int(input())

HEAP = []

for _ in range(N):
    n = int(input())
    if n == 0:
        biggest = 0
        if len(HEAP) > 0:
            biggest = -heapq.heappop(HEAP)
        print(biggest)
    else:
        heapq.heappush(HEAP, -n)
