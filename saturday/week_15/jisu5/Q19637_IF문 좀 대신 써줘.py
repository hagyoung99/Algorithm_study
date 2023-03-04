n, m = map(int, input().split())
powerList = [0] * n

def check_power(power):
    start, end = 0, n - 1
    result = powerList[end][0]
    while start <= end:
        mid = (start + end) // 2
        if power <= powerList[mid][1]:
            result = powerList[mid][0]
            end = mid - 1
        else:
            start = mid + 1
    return result

for idx in range (n):
    name, power = input().split()
    powerList[idx] = [name, int(power)]

for _ in range(m):
    character = int(input())
    print(check_power(character))


