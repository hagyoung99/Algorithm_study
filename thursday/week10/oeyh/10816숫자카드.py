import sys

n = int(sys.stdin.readline())
card = list(map(int, sys.stdin.readline().split()))
m = int(sys.stdin.readline())
target = list(map(int, sys.stdin.readline().split()))

hash = {}
result = []

for c in card:
    if card in hash:
        hash[c] += 1
    else:
        hash[c] = 1

for t in target:
        if t in hash:
            result.append(hash[t])
        else:
            result.append(0)
result = ' '.join(map(str, result))

print(result)