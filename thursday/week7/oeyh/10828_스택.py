import sys

N = int(sys.stdin.readline())

stack = []

for _ in range(N):
    o = sys.stdin.readline().rstrip()
    l = len(stack)

    if o == "pop":
        print(stack.pop() if l > 0 else -1)
    elif o == "size":
        print(l)
    elif o == "empty":
        print(1 if l == 0 else 0)
    elif o == "top":
        print(stack[-1] if l > 0 else -1)
    else:
        a = o.split()
        stack.append(a[1])