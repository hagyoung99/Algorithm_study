n = int(input())
arr = [False, False] + [True] * (n - 1)
prime_num = []

for i in range(2, n + 1):
    if arr[i]:
        prime_num.append(i)

        for j in range(2 * i, n + 1, i):
            arr[j] = False

answer = 0
start, end = 0, 0
while end <= len(prime_num):
    sum_ = sum(prime_num[start:end])
    if sum_ == n:
        answer += 1
        end += 1
    elif sum_ < n:
        end += 1
    else:
        start += 1

print(answer)