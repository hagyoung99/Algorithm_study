import sys
n = int(sys.stdin.readline())

arr = [0] * 10001
for _ in range(n):
    j = int(sys.stdin.readline())
    arr[j] += 1
    
for i in range(10001):
    if arr[i] != 0:
        for j in range(arr[i]):
            print(i)
    