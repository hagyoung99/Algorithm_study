import sys
N,k = map(int, sys.stdin.readline().split())
x = list(map(int, sys.stdin.readline().split()))
x.sort()
print(x[N - k])