import sys

input = sys.stdin.readline

N = int(input())
nums = [0] * N
for i in range(N):
    nums[i] = int(input())


for i in range(0, len(nums)):
    for j in range(1, len(nums)-i):
        if nums[j-1] > nums[j]:
            nums[j-1], nums[j] = nums[j], nums[j-1]

for n in nums:
    print(n)
