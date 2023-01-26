import heapq
from heapq import heappush, heappop
import sys

N = int(sys.stdin.readline())
heap = []

for _ in range(N):
    x = int(sys.stdin.readline())

    if x != 0:
        heapq.heappush(heap, (-1)*x)
    else:
        try:
            print((-1) * heapq.heappop(heap))
        except:
            print(0)

