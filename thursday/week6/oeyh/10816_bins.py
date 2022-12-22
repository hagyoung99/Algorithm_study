import sys


def binary_search(array, target, start, end):
    if start > end:
        return 0

    mid = (start + end) // 2

    if array[mid] == target:
        return mid
    elif array[mid] > target:
        return binary_search(array, target, start, mid - 1)
    else:
        return binary_search(array, target, mid + 1, end)


n = int(sys.stdin.readline())
card_arr = list(map(int, sys.stdin.readline().split()))
m = int(sys.stdin.readline())
find_arr = list(map(int, sys.stdin.readline().split()))
result_arr = []

card_arr.sort()

for i in range(m):
    pass
    # result_arr.append(card_arr.count(find_arr[i])) >> count는 시간복잡도가 O(n)

result = " ".join(map(str, result_arr))

print(result)

