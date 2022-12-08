
N = int(input())
result = 0

for i in range(1, N + 1):
  tmp = i + sum(map(int,str(i)))

  if tmp == N:
    result = i
    break

print(result)