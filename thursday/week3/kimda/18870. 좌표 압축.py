import sys
input = sys.stdin.readline
n = int(input())
data = list(map(int, input().split()))

data2 = sorted(list(set(data)))
dic = {data2[i] : i for i in range(len(data2))}
for i in data:
    print(dic[i], end=' ')