import sys
n = int(input())
arr = []

for i in range(n):
    arr.append(sys.stdin.readline())

arr.sort(key=lambda x: (int(x.split()[1]), int(x.split()[0])))
print("".join(arr))