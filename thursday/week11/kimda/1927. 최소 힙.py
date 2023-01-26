# 파이썬 heapq 내장 모듈은 이진 트리 기반의 최소 힙 자료구조를 제공한다.
import heapq
import sys
input = sys.stdin.readline
n = int(input())
# 최소 힙 생성
heap = []
result = []

for _ in range(n):
    num = int(input())
    if num == 0:
        if heap:
            print(heapq.heappop(heap))
        else:
            print(0)
    else:
        heapq.heappush(heap, num)
