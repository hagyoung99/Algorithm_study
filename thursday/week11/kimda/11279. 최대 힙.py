import sys
import heapq
n = int(input())
heap = []
for i in range(n):
    num= int(sys.stdin.readline())
    if num == 0:
        if heap:
            print((-1)*heapq.heappop(heap))
        else:
            print(0)
    else:
        heapq.heappush(heap, (-1) * num)