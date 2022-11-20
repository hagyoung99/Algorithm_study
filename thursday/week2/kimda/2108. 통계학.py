import sys
from collections import Counter
n = int(input())
nums = [int(sys.stdin.readline()) for _ in range(n)]
# nums = [1, 3, 8, -2, 2]
nums.sort()

# 산술평균
sum_ = 0
for num in nums:
    sum_ += num
avg = round(sum_ /n)

# 중앙값
mid = round(nums[n//2])

# 최빈값
cnt = Counter(nums).most_common()
# cnt = [(-2, 1), (1, 1), (2, 1), (3, 1), (8, 1)]
# 최빈값이 여러개 있을 때는 두번째로 작은 값 출력
if len(cnt) > 1 and cnt[0][1] == cnt[1][1]:
    max_cnt = cnt[1][0]
else:
    max_cnt = cnt[0][0]

# 범위
rng = nums[-1] - nums[0]

print(avg)
print(mid)
print(max_cnt)
print(rng)