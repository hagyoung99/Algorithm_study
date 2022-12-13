import sys
n = int(input())

data = []
for i in range(n):
    data.append(sys.stdin.readline())

data.sort(key=lambda x: (int(x.split()[0])))

print(''.join(data))