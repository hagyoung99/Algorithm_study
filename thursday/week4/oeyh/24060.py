import sys

input = sys.stdin.readline


def mergeSort(L):
    if len(L) == 1:
        return L

    mid = (len(L) + 1) // 2
    left = mergeSort(L[:mid])
    right = mergeSort(L[mid:])

    L2 = []
    i = 0
    j = 0

    while i < len(left) and j < len(right):
        if left[i] < right[j]:
            L2.append(left[i])
            ans.append(left[i])
            i += 1
        else:
            L2.append(right[j])
            ans.append(right[j])
            j += 1

    while i < len(left):
        L2.append(left[i])
        ans.append(left[i])
        i += 1

    while j < len(right):
        L2.append(right[j])
        ans.append(right[j])
        j += 1

    return L2


n, k = map(int, input().split())
a = list(map(int, input().split()))

ans = []
mergeSort(a)

if len(ans) >= k:
    print(ans[k - 1])
else:
    print(-1)