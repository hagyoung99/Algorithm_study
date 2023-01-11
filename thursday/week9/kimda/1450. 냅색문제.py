# meet in the middle 알고리즘 사용 : 적당한 n이 주어질 때, 완전탐색을 하기에는 시간초과가 뜨는 문제
# 집합을 두 부분으로 나눠, 각각의 집합에 연산을 진행한다. 두 결과를 이용해 조건을 만족하는 경우의 수를 구한다.

import sys
input = sys.stdin.readline

n, c = map(int, input().split())
weight = list(map(int, input().split()))
aw = weight[:n // 2]
bw = weight[n//2:]
a_sum = []
b_sum = []

# aw, bw 각각을 브루트포스 알고리즘으로 부분 집합의 합을 구하고 각각 a_sum과 b_sum에 추가해준다.
def bruteforce(weight_arr, sum_arr, l, w):
    if l >= len(weight_arr):
        sum_arr.append(w)
        return
    bruteforce(weight_arr, sum_arr, l + 1, w)
    bruteforce(weight_arr, sum_arr, l + 1, w + weight_arr[l])

def binarySearch(arr, target, start, end):
    while start < end:
        mid = (start + end) // 2
        if arr[mid] <= target:
            start = mid + 1
        else:
            end = mid
    return end

bruteforce(aw, a_sum, 0, 0)
bruteforce(bw, b_sum, 0, 0)
# 이분 탐색을 위한 정렬
b_sum.sort()
# print(a_sum, b_sum)

cnt = 0
# a 부분집합과 b 부분 집합의 합이 c보다 작은 값들을 카운트 해줌.
for i in a_sum:
    # c - i가 0보다 작다는 것은 i가 c보다 큰 값이라 가방에 들어가지 않는다는 뜻. 그래서 그냥 넘어가기!
    if c - i < 0:
        continue
    #
    cnt += binarySearch(b_sum, c - i, 0, len(b_sum))
print(cnt)
