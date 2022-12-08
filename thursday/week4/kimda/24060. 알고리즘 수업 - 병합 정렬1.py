def merge_sort(arr):
    if len(arr) == 1:
        return arr
    mid = (len(arr) + 1) // 2

    left = merge_sort(arr[:mid])
    right = merge_sort(arr[mid:])

    i, j = 0, 0
    lst = []
    while i < len(left) and j < len(right):
        if left[i] < right[j]:
            lst.append(left[i])
            ans.append(left[i])
            i += 1
        else:
            lst.append(right[j])
            ans.append(right[j])
            j += 1

    while i < len(left):
        lst.append(left[i])
        ans.append(left[i])
        i += 1
    while j < len(right):
        lst.append(right[j])
        ans.append(right[j])
        j += 1
    return lst

n, k = map(int, input().split())
arr = list(map(int, input().split()))
ans = []
merge_sort(arr)

if len(ans) >= k:
    print(ans[k-1])
else:
    print(-1)