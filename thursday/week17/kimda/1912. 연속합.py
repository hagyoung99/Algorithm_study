n = int(input())
data = list(map(int, input().split()))

sum = [data[0]]
for i in range(len(data) - 1):
    sum.append(max(sum[i] + data[i+1], data[i+1]))
print(max(sum), sum)