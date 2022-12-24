import sys
input = sys.stdin.readline

n = int(input())
stack = []

for _ in range(n):
    data = input().strip().split(' ')
    if data[0] == 'push':
        stack.append(int(data[1]))
    elif data[0] == 'pop':
        if len(stack) == 0:
            print(-1)
        else:
            print(stack.pop())
    elif data[0] == 'size':
        print(len(stack))
    elif data[0] == 'empty':
        if len(stack) == 0:
            print(1)
        else:
            print(0)
    elif data[0] == 'top':
        if len(stack) == 0 :
            print(-1)
        else:
            print(stack[-1])