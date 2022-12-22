import sys


def binary_search(array, target, start, end):
    if start > end:
        return 0

    mid = (start + end) //2

    if array[mid] == target:
        return 1
    elif array[mid] > target:
        return binary_search(array, target, start, mid-1)
    else:
        return binary_search(array, target, mid +1, end)


n = int(sys.stdin.readline())
card_arr = list(map(int, sys.stdin.readline().split()))
m = int(sys.stdin.readline())
value_arr = list(map(int, sys.stdin.readline().split()))

card_arr.sort()
result = []

for v in value_arr:
    result.append(binary_search(card_arr, v, 0, n-1))

result = ' '.join(map(str, result))

print(result)