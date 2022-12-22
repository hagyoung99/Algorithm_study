import sys

n = sys.stdin.readline().rstrip()
result = set()
for i in range(len(n)):
    for j in range(i, len(n)):
        result.add(n[i:j+1])

print(len(result))