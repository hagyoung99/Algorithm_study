N, K = map(int, input().split())

NUMS = list(map(int, input().split()))

ans = 0
mp = {}

l, r = 0, 0

while r < N:
    lv, rv = NUMS[l], NUMS[r]
    rv_cnt = mp.get(rv, 0)

    if rv_cnt < K:
        mp[rv] = rv_cnt + 1
        r += 1

    else:
        mp[lv] = mp.get(lv, 1) - 1
        l += 1

    ans = max(ans, r - l)

print(ans)
