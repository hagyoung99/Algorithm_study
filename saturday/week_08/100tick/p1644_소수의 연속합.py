import math

n = int(input())

primes = []
NUMS = [True for _ in range(n + 1)]

for i in range(2, int(math.sqrt(n)) + 1):
    if NUMS[i]:
        j = 2

        while i * j <= n:
            NUMS[i * j] = False
            j += 1

for i in range(2, n + 1):
    if NUMS[i]:
        primes.append(i)

cnt = 0
s = 0
end = 0

for start in range(len(primes)):
    while s < n and end < len(primes):
        s += primes[end]
        end += 1

    if s == n:
        cnt += 1
    s -= primes[start]

print(cnt)
