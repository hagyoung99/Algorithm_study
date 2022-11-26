import sys

n = int(sys.stdin.readline())
#strip으로 개행을 제거하고 set으로 중복을 제거, 이름 순으로 정렬한 후 길이 순 정렬
li = []
for i in range(n):
    li.append(sys.stdin.readline().strip())

sl = set(li)
li = list(sl)

li.sort()
li.sort(key=len)

for i in li:
    print(i)