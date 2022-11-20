nums = list(map(int,input()))
nums.sort(reverse=True)

for num in nums:
    print(num, end='')