import sys
n = int(sys.stdin.readline())

array = [0 for _ in range(10001)]
data = []
for i in range(n):
    data = int(sys.stdin.readline())
    array[data] += 1

for i in range(len(array)):
    for j in range(array[i]):
        print(i)