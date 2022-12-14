import sys
input = sys.stdin.readline
n = int(input())
arr_n = list(map(int, input().split()))
m = int(input())
arr_m = list(map(int, input().split()))

dict_ = {}
for i in range(n):
    dict_[arr_n[i]] = 0

for j in range(m):
    if arr_m[j] not in dict_:
        print(0, end=' ')
    else:
        print(1, end=' ')