n = int(input())

arr = []
for i in range(n):
    arr.append(list(map(int, input().split())))

arr.sort()
for a in arr:
    print(a[0], a[1])