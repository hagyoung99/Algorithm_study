N = int(input())
NUMS = list(map(int, input().split()))
X = int(input())

ANS = 0
# NUMS[i] + NUMS[j] == X 경우의 수

# 1. ASC 정렬(O(logN))
# 2. left, right 포인터 0,last부터 시작하여 쌍을 구함(O(N))

NUMS.sort()

left, right = 0, N-1

while left < right:
    total = NUMS[left] + NUMS[right]
    if total == X:
        ANS += 1
        left += 1
        right -= 1
    elif total > X:
        right -= 1
    elif total < X:
        left += 1
print(ANS)
