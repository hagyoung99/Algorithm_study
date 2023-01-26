import sys
input = sys.stdin.readline

n = int(input())
data = list(map(int, input().split()))
lis = [0]

for i in data:
    if lis[-1] < i:
        lis.append(i)
    else:
        left = 0
        right = len(lis)

        while left < right:
            mid = (left + right) // 2
            if lis[mid] < i:
                left = mid + 1
            else:
                right = mid
        lis[right] = i
print(len(lis) - 1)
