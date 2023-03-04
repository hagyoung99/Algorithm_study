N = int(input())
my_cards = sorted(list(map(int, input().split())))
M = int(input())
cards = list(map(int, input().split()))


arr = [0] * M


def search(n):
    lo, hi = 0, N-1

    while lo <= hi:
        mid = (lo+hi)//2

        if my_cards[mid] == n:
            return 1

        elif my_cards[mid] > n:
            hi = mid-1

        else:
            lo = mid+1

    return 0


for i, c in enumerate(cards):
    arr[i] = search(c)

print(*arr)
