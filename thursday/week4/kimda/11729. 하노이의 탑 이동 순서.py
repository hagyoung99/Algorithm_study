def hanoi(n, x, y):
    if n == 1:
        print(x, y)
        return

    hanoi(n-1, x, 6-x-y)
    print(x, y)
    hanoi(n-1, 6-x-y, y)

n = int(input())
print(2**n-1)
hanoi(n, 1, 3)