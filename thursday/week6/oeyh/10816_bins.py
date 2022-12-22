import sys
import time
start = time.time()  # 시작 시간 저장

def binary_search(array, target, start, end):
    if start > end:
        return 0

    mid = (start + end)//2

    if array[mid] == target:
        i, j = 0, 0
        while (mid+i) <= end:
            if array[mid+i] != target:
                break
            else:
                i += 1
        while (mid-j) >= start:
            if array[mid-j] != target:
                break
            else:
                j += 1
        return i + j - 1
    elif array[mid] > target:
        return binary_search(array, target, start, mid-1)
    else:
        return binary_search(array, target, mid+1, end)


n = int(sys.stdin.readline())
card_arr = sorted(map(int, sys.stdin.readline().split()))
_ = int(sys.stdin.readline())
value_arr = map(int, sys.stdin.readline().split())
result_arr = []

for v in value_arr:
    # result_arr.append(card_arr.count(find_arr[i])) >> count는 시간복잡도가 O(n)
    result_arr.append(binary_search(card_arr, v, 0, n-1))

result = " ".join(map(str, result_arr))

print(result)
print("time :", time.time() - start)
