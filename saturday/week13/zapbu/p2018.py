N = int(input())

l, r = 0, 0
ans, sum = 1, 0

while r < N:
    if sum < N:
        r += 1
        sum += r
    elif sum > N:
        sum -= l
        l += 1
    else:
        ans += 1
        r += 1
        sum += -l + r
        l += 1

print(ans)
