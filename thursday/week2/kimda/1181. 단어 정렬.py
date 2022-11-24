import sys
n = int(input())
arr = []

for i in range(n):
    arr.append(sys.stdin.readline())
a = list(set(arr))
a.sort(key=lambda x: (len(x), x))
print("".join(a))