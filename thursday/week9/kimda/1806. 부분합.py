import sys
input = sys.stdin.readline

n, s = map(int, input().split())
arr = list(map(int, input().split())) # 5 1 3 5 10 7 4 9 2 8

end = 0
i_sum = 0
count = 0
lst = []

for start in range(n):
    while i_sum < s and end < n:
        i_sum += arr[end]
        end += 1

    if i_sum >= s:
        count += 1
        lst.append(len(arr[start:end]))

    i_sum -= arr[start]

if lst:
    print(min(lst))
else:
    print(0)