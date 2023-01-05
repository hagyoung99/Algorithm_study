from collections import deque
import sys
input = sys.stdin.readline
n = int(input())
a = deque()

for i in range(n):
    word = input().split()
    if word[0] == 'push_front':
        a.appendleft(word[1])
    elif word[0] == 'push_back':
        a.append(word[1])
    elif word[0] == 'pop_front':
        if len(a) == 0:
            print(-1)
        else:
            print(a.popleft())
    elif word[0] == 'pop_back':
        if len(a) == 0:
            print(-1)
        else:
            print(a.pop())
    elif word[0] == 'size':
        print(len(a))
    elif word[0] == 'empty':
        if len(a) == 0:
            print(1)
        else:
            print(0)
    elif word[0] == 'front':
        if len(a) == 0:
            print(-1)
        else:
            print(a[0])
    elif word[0] == 'back':
        if len(a) == 0:
            print(-1)
        else:
            print(a[-1])