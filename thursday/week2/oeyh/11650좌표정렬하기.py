import sys

n = int(sys.stdin.readline())

point = []
for i in range(n):
    point.append(list(map(int, sys.stdin.readline().split())))

#sort의 key에 람다식을 적용, x[0]를 먼저 정렬 후, x[1]를 정렬
point.sort(key=lambda x: (x[0], x[1]))

for p in point:
    print(p[0], p[1])