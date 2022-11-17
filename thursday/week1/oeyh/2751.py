import sys

n = int(sys.stdin.readline()) #input보단 메모리 사용량이 적음
data = sorted([int(sys.stdin.readline()) for i in range(n)])

#append는 메모리의 재할당이 일어나 속도가 저하되고 메모리 사용량이 올라감

for i in data:
    print(i)
  