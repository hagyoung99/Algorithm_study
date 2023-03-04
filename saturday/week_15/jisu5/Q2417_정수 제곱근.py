num = int(input())
left = 0
right = num
result = 0
while left <= right:
    mid = (left + right) // 2
    if mid ** 2 < num:
        left = mid + 1
    else:
        result = mid
        right = mid - 1 

print(result)