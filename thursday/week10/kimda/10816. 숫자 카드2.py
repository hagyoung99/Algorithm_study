def binary_search(arr, value, start, end):
    if start > end:
        return 0
    mid = (start + end) // 2
    if arr[mid] == value:
        # cnt 딕셔너리에서 value라는 키를 가진 값을 가져온다. 예제에서 value가 -10이면 cnt.get(-10)은 2
        return cnt.get(value)
    elif arr[mid] > value:
        return binary_search(arr, value, start, mid - 1)
    else:
        return binary_search(arr, value, mid + 1, end)

n = int(input())
n_arr = list(map(int, input().split()))
m = int(input())
m_arr = list(map(int, input().split()))
n_arr.sort()

# 딕셔너리 이용해서 n_arr 각 숫자의 갯수 세어주기
cnt = {}
for i in n_arr:
    if i in cnt:
        cnt[i] += 1
    else:
        cnt[i] = 1
# print(cnt) => {-10: 2, 2: 1, 3: 2, 6: 1, 7: 1, 10: 3}

for j in m_arr:
    print(binary_search(n_arr, j, 0, len(n_arr) - 1), end=' ')