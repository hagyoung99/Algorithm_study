N = int(input())

lo, hi = 0, N//2+1

ANS = 0

while lo <= hi:
    mid = (lo+hi)//2

    if mid**2 >= N:
        hi = mid-1
        ANS = mid
    else:
        lo = mid+1

print(ANS)
