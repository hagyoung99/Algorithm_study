n = int(input())
data = [int(input()) for _ in range(n)]
dp = [0 for i in range(301)]

dp[0] = data[0]
dp[1] = data[0] + data[1]
# 첫번재 계단을 밝고 2칸 올라간 경우와 한칸씩 올라간 경우 중 더 큰 값을 저장한다.
dp[2] = max(data[0] + data[2], data[1] + data[2])

for i in range(3, n):
    # 3번째 계단부터는 두 가지 경우로 나누어서 최댓값 저장
    # 1. 현재 계단을 두칸 오르고, 한칸 올라와 도착했을 때
    # 2. 현재 계단을 한칸 오르고, 두칸 올라와 도착했을 때
    dp[i] = max(dp[i-3]+data[i-1]+data[i], dp[i-2]+data[i])
print(dp[n-1])