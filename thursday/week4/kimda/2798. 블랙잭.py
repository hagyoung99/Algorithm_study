n, m = map(int,input().split())
arr = list(map(int, input().split()))

data = []
sum = 0
for i in range(0, n-2):
    for j in range(i+1, n-1):
        for k in range(i+2, n):
            if arr[j] == arr[k] or j > k:
                continue
            data.append(arr[i] + arr[j] + arr[k])

max_data = 0
for i in data:
    if i <= m and max_data < i:
        max_data = i
print(max_data)