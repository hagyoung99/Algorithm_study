import sys
input = sys.stdin.readline
n = int(input())
arr_n = list(map(int, input().split()))
m = int(input())
arr_m = list(map(int, input().split()))

d = dict()
for i in arr_n:
    if i in d.keys():
        d[i] += 1
    else:
        d[i] = 1

for i in arr_m:
    if i in d.keys():
        print(d[i], end=' ')
    else:
        print(0, end=' ')