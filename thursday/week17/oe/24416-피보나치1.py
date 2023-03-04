import sys

n = int(sys.stdin.readline())
cnt1, cnt2 = 1, 0
def fib(n):
    global cnt1
    if n <= 2:
        return 1

    cnt1 += 1
    return fib(n - 1) + fib(n - 2)

def fibonacci(n):
    global cnt2
    dp = [0] * (n+1)
    dp[1], dp[2] = 1, 1
    for i in range(3, n+1):
        cnt2 += 1
        dp[i] = dp[i-1] + dp[i-2]
    return dp[n]


fib(n)
fibonacci(n)
print(cnt1, cnt2)