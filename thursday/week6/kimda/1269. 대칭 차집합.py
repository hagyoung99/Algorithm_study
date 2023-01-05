n, m = map(int, input().split())
arr_n = list(map(int, input().split()))
arr_m = list(map(int, input().split()))

d = list(set(arr_n) - set(arr_m)) + list(set(arr_m) - set(arr_n))
print(len(d))