n = int(input())
data = list(map(int, input().split()))

list = [1] * n

for i in range(1, n):
    for j in range(0, i):
        if data[j] < data[i]:
            list[i] = max(list[i], list[j] + 1)
# list => [1, 2, 1, 3, 2, 4]

print(max(list))