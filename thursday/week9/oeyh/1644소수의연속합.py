import sys

n = int(sys.stdin.readline())

end = 0
subtotal = 0
cnt = 0

a = [False, False] + [True] * (n-1)
primes = []

for i in range(2, n+1):
    if a[i]:
        primes.append(i)

        for j in range(2*i, n+1, i):
            a[j] = False

prime_len = len(primes)

for start in range(prime_len):
    while subtotal < n and end < prime_len:
        subtotal += primes[end]
        end += 1

    if subtotal == n:
        cnt += 1
    subtotal -= primes[start]

print(cnt)
