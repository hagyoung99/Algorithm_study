import sys

def binary_search(array, target, start, end):
    if start > end:
        return 0

    mid = (start + end) //2
    if array[mid] == target:
        return 1
    elif array[mid] < target:
        return binary_search(array, target, mid +1, end)
    else:
        return binary_search(array, target, start, mid-1)

N = int(sys.stdin.readline())
array = list(map(int, sys.stdin.readline().split()))
M = int(sys.stdin.readline())
target_array = list(map(int, sys.stdin.readline().split()))

array.sort()

for target in target_array:
    print(binary_search(array, target, 0, N-1))

